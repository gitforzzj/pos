<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>z4豪华西餐店</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript">
	var editIndex ;
	
	//解决datagrid combobox 显示id不显示值问题
	var comboboxData = "";  
	 
	
    function GetLevelDTAJ()  
    {  
        $.ajax({  
            url: "categoryAction_findAll.action",  
            type: 'get',  
            async: false,//此处必须是同步  
            dataTye: 'json',  
            success: function (data) {  
                comboboxData = data;  
            }  
        })  
        return comboboxData;  
    }  

    function fmLevelAJ(value, row) {  
        
        for (var i = 0; i < comboboxData.length; i++) {  
            if (comboboxData[i].id == value) {  
                return comboboxData[i].name;  
            }  
        }  
        return row.categoryName;  
    }  
	
	function doAdd(){
		if(editIndex != undefined){
			$("#grid").datagrid('endEdit',editIndex);
		}
		if(editIndex==undefined){
			$("#grid").datagrid('insertRow',{
				index : 0,
				row : {}
			});
			$("#grid").datagrid('beginEdit',0);
			editIndex = 0;
		}
	}
	
	function doSave(){
		$("#grid").datagrid('endEdit',editIndex );
	}
	
	function doCancel(){
		if(editIndex!=undefined){
			$("#grid").datagrid('cancelEdit',editIndex);
			if($('#grid').datagrid('getRows')[editIndex].id == undefined){
				$("#grid").datagrid('deleteRow',editIndex);
			}
			editIndex = undefined;
		}
	}
	
		  function doSearch(value,name){ //用户输入用户名,点击搜素,触发此函数

			  
				$("body").css({visibility:"visible"});
				
				// 收派标准数据表格
				$('#grid').datagrid( {
					/////////
							title:'searchBox',  
				            iconCls:'icon-ok',  
				            pageList:[1,10,15,20],  
				            nowrap:true,  
				            striped:true,  
				            collapsible:true,  
				            toolbar:"#easyui_toolbar",  
				            url:'dishAction_page.action?dishid='+value, //触发此action,带上参数searcValue   
				            loadMsg:'数据加载中......',  
				            fitColumns:true,//允许表格自动缩放,以适应父容器  
				            sortName:'userId',  
				            sortOrder:'asc',  
				            remoteSort:false,  
				            columns : columns,  
				            pagination : true,  
				            fit:true,
				            rownumbers : true ,
				            border : true,
					/* /////
					iconCls : 'icon-forward',
					fit : true,
					border : true,
					rownumbers : true,
					striped : true,
					pageList: [30,50,100],
					pagination : true,
					toolbar : toolbar,
					url :  "dishAction_pageQuery.action",
					idField : 'id',
					columns : columns, */
					onDblClickRow : doDblClickRow,
					onAfterEdit : function(rowIndex, rowData, changes){
						/* console.info(rowData); */
						editIndex = undefined;
						$.post('dishAction_saveOrUpdate.action',rowData,function(data){
							if(data == 0){
								$.messager.alert("提示信息","工作单录入失败!","error");
							}
						});
					}
				});
			  
			  
		       
		    }  
		
   
		  
	
	function doEdit(){
		var rows =$("#grid").datagrid("getSelections");
		
		if(rows.length==1){
			var row = rows[0];
			myIndex = $("#grid").datagrid("getRowIndex",row);
			
		
		$('#grid').datagrid('beginEdit',myIndex);
		editIndex = myIndex;
		
		}else{
		$.messager.alert("提示信息","请选择一行!","warning");
		}
	}
	
	function doDelete(){
    	//获得选中的行对象
    	 var rows = $("#grid").datagrid("getSelections");
    	 var dishid = rows[0].dishid;
    	 if(rows.length == 1){
    		 var row = rows[0];
    		 //获得指定行对象的索引
    		 myIndex = $("#grid").datagrid("getRowIndex",row);
    	
    	 $.messager.confirm("提示信息","你确定要删除当前记录吗？",function(r){
    		 if(r){
    			 $("#grid").datagrid("deleteRow",myIndex);
            	 $.post('dishAction_delete.action',{"dishid":dishid},function(data){
        				if(data == 0){
        					$.messager.alert("提示信息","工作单删除失败!","error");
        				}
        		});
    		 }
    		 
 		});
    	} else{
    		$.messager.alert("提示信息","请选择一行!","warning");
    	}
     }
	
	//工具栏
	var toolbar ='#easyui_toolbar'; /* [{
		id : 'button-edit',
		text : '修改',
		iconCls : 'icon-edit',
		handler: doEdit
	}, {
		id : 'button-add',	
		text : '新增一行',
		iconCls : 'icon-add',
		handler : doAdd
	}, {
		id : 'button-cancel',
		text : '取消编辑',
		iconCls : 'icon-cancel',
		handler : doCancel
	}, {
		id : 'button-delete',	
		text : '删除',
		iconCls : 'icon-cancel',
		handler : doDelete
	},{
		id : 'button-save',
		text : '保存',
		iconCls : 'icon-save',
		handler : doSave
	},
	'#tb'
	]; */
	// 定义列
	var columns = [ [ {
		field : 'dishid',
		title : '菜单编号',
		width : 120,
		align : 'center',
		editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		} 
	}, {
		field : 'dishname',
		title : '菜品名称',
		width : 120,
		align : 'center',
		editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		}
	},{
		field : 'unit',
		title : '单位',
		width : 120,
		align : 'center',
		editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		}
	}, {
		field : 'price',
		title : '单价',
		width : 120,
		align : 'center',
		editor :{
			type : 'numberbox',
			options : {
				required: true
			}
		}
	}, {
		field : 'categoryName',
		title : '类别',
		width : 120,
		formatter : fmLevelAJ, 
		align : 'center',
		editor :{
			
       		 type: 'combobox',
            options: {
                editable:false,
                required: true,
                valueField: 'id',
                textField: 'name',
                data:GetLevelDTAJ()
                
                /* url: 'categoryAction_findAll.action' */
            }
       
		}
	}] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		
		// 收派标准数据表格
		$('#grid').datagrid( {
			/////////
					title:'searchBox',  
		            iconCls:'icon-ok',  
		            pageList:[1,10,15,20],  
		            nowrap:true,  
		            striped:true,  
		            collapsible:true,  
		            toolbar:"#easyui_toolbar",  
		            url:"dishAction_pageQuery.action", //触发此action,带上参数searcValue  
		            loadMsg:'数据加载中......',  
		            fitColumns:true,//允许表格自动缩放,以适应父容器  
		            sortName:'userId',  
		            sortOrder:'asc',  
		            remoteSort:false,  
		            columns : columns,  
		            pagination : true,  
		            fit:true,
		            rownumbers : true ,
		            border : true,
			/* /////
			iconCls : 'icon-forward',
			fit : true,
			border : true,
			rownumbers : true,
			striped : true,
			pageList: [30,50,100],
			pagination : true,
			toolbar : toolbar,
			url :  "dishAction_pageQuery.action",
			idField : 'id',
			columns : columns, */
			onDblClickRow : doDblClickRow,
			onAfterEdit : function(rowIndex, rowData, changes){
				/* console.info(rowData); */
				editIndex = undefined;
				$.post('dishAction_saveOrUpdate.action',rowData,function(data){
					if(data == 0){
						$.messager.alert("提示信息","工作单录入失败!","error");
					}
				});
			}
		});
		
		$('#category').combobox({ 

			url:'categoryAction_findAll.action', 

			valueField:'id', 

			textField:'name',
			
			onSelect: function (data) {
				$('#grid').datagrid( {
	                url: "dishAction_findByCategoryId.action?category.id="+data.id
				
				});
			}
		});
		
		$("#button-import").upload({
			action:'${pageContext.request.contextPath}/dishAction_importXls.action',
			name:'dishFile',
			onComplete:function (data) { //提交表单之后
		           if(data == "0"){
		        	   $.messager.alert("提示信息","excel导入成功!","show",function(){
		        		   window.location.reload();
		        	   });
		            }else if(data == "1"){
		            	 $.messager.alert("提示信息","Excel导入失败!","error",function(){
			        		   window.location.reload();
			        	   });//提示框，Excel导入成失败
		            }else if(data == "2"){
		            	 $.messager.alert("提示信息","Excel导入失败,对应行不匹配,请按页面数据表格的顺序进行数据排序!","error",function(){
			        		   window.location.reload();
			        	   }); //提示框，Excel导入成失败
		            }
		        },
		        onSelect: function() {//当用户选择了一个文件后触发事件
		            //当选择了文件后，关闭自动提交
		            this.autoSubmit=false;
		            //校验上传的文件名是否满足后缀为.xls或.xlsx
		            var regex =/^.*\.(?:xls|xlsx)$/i;
		            //this.filename()返回当前选择的文件名称 (ps：我使用这个方法没好使，自己写了一个获取文件的名的方法) $("[name = '"+this.name()+"']").val())
		            //alert(this.filename());
		            if(regex.test($("[name = '"+this.name()+"']").val())){
		                //通过校验
		                this.submit();
		            }else{
		                //未通过
		                 $.messager.alert("提示信息","文件格式不正确，必须以.xls或.xlsx结尾!","error"); //错误提示框，文件格式不正确，必须以.xls或.xlsx结尾
		            }
		        }
		});
	});

	
	
	function doDblClickRow(rowIndex, rowData){
		$('#grid').datagrid('beginEdit',rowIndex);
		editIndex = rowIndex;
	}
</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">





	<div region="center" border="false">
		
    	<table id="grid">
    	
    	
         
         </table>
         <div  id="easyui_toolbar" region="north" border="false"  
                style="border-bottom: 1px solid #ddd; height: 32px; padding: 2px 5px; background: #fafafa;">  
                
                <div id="tb" style="float: left;">  
                    <input id="searchtype"  class="easyui-searchbox"  prompt="输入菜单编号"  searcher="doSearch" style="width: 180px; vertical-align: middle;"></input>   
                </div>  
                <div class="datagrid-btn-separator"></div>  
                <div style="float: left;">  
                    <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="doAdd()">新增</a>  
                </div>  
  
                <div class="datagrid-btn-separator"></div>  
                
                <div style="float: left;">  
                    <a href="#" class="easyui-linkbutton" plain="true"  
                        icon="icon-edit" onclick="doEdit()">修改</a>  
                </div> 
  		
  				<div class="datagrid-btn-separator"></div>  
  
                <div style="float: left;">  
                    <a href="#" class="easyui-linkbutton" plain="true"  
                        icon="icon-cancel" onclick="doCancel()">取消编辑</a>  
                </div> 
  				
                <div class="datagrid-btn-separator"></div> 
  					
                <div style="float: left;">  
                    <a href="#" class="easyui-linkbutton" plain="true" icon="icon-save" onclick="doSave()">保存</a>  
                </div>  
  
                <div class="datagrid-btn-separator"></div>  
  
                <div style="float: left;">  
                    <a href="#" class="easyui-linkbutton" plain="true"  
                        icon="icon-remove" onclick="doDelete()">删除</a>  
                </div> 
                
                <div class="datagrid-btn-separator"></div>  
  
                <div style="float: left;">  
                    <a href="#" id="button-import" class="easyui-linkbutton" plain="true"  
                        icon="icon-redo" >导入</a>  
                </div>  
                
                <div class="datagrid-btn-separator"></div> 
  				
  				<div style="float: right;">
  					<font color="blue">选择类别:</font>
  					<input id="category" name="category" value="全部分类">
  				</div>	
  		
            </div>   
         </div>   
	</div>
</body>
</html>