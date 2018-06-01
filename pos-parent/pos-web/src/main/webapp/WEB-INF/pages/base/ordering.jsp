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
	
	function doAdd(index){
		var flag =1;
		$('#grid').datagrid('selectRow', index);  
		var rows =$("#grid").datagrid("getSelections");
		 //这段代码是获取当前页的所有行。
		 var allrows = $("#orderDetailGrid").datagrid("getRows");
		 var num = $("input[name=num]").val();
		 var taste = $("input[name=taste]").val();
		 
			 for(var i=0;i<allrows.length;i++)
			 {
				 //获取每一行的数据
				 if(rows[0].dishid==allrows[i].dishes.dishid){
					 
					 if(taste==allrows[i].taste){
						 $.post('orderDetailAction_update.action',{"dishes.dishid":rows[0].dishid,"num":Number(allrows[i].num)+Number(num),"taste":taste},function(data){
							 if(data == 1){
								/* var p=$("#searchForm").serializeJson();
								console.info(p); */
								$("#orderDetailGrid").datagrid("load");/* 
								$("#searchWindow").window("close"); */
							} else{
								$.messager.alert("提示信息","菜品更新失败!","error");
							}
						});
						 flag=0;
					 }
					
				 }
			 }
		
		
		 if(flag==1){
			 if(rows.length==1){
					var dishid = rows[0].dishid;
					var taste = $("input[name=taste]").val();
					var num = $("input[name=num]").val();
					$.post('orderDetailAction_add.action',{"dishes.dishid":dishid,"taste":taste,"num":num},function(data){
						 if(data == 1){
							/* var p=$("#searchForm").serializeJson();
							console.info(p); */
							$("#orderDetailGrid").datagrid("load");/* 
							$("#searchWindow").window("close"); */
						} else if(data==-1){
							$.messager.alert("提示信息","菜品添加失败,请先点击新单!","error");
						}else{

							$.messager.alert("提示信息","菜品添加失败!","error");
						}
					});
				}else{
					$.messager.alert("提示信息","请选择一行!","warning");
				}
		 }
		
	}
	
	function doDelete(index){
		$('#orderDetailGrid').datagrid('selectRow', index);  
		var rows =$("#orderDetailGrid").datagrid("getSelections");
		
		if(rows.length==1){
			var dishid = rows[0].dishes.dishid;
			var taste = rows[0].taste;/* 
			var num = $("input[name=num]").val(); */
			$.post('orderDetailAction_del.action',{"dishes.dishid":dishid,"taste":taste},function(data){
				 if(data == 1){
					/* var p=$("#searchForm").serializeJson();
					console.info(p); */
					$("#orderDetailGrid").datagrid("load");/* 
					$("#searchWindow").window("close"); */
				} else{

					$.messager.alert("提示信息","菜品移除失败!","error");
				}
			});
		}else{
			$.messager.alert("提示信息","请选择一行!","warning");
		}
	}
	
	
	function newOrder(){
		
		var allrows = $("#orderDetailGrid").datagrid("getRows");
		if(allrows!=""){
			
			$.messager.confirm('提示信息','订单还没结账，是否放弃创建新订单？',function(r){ 

				if (r){ 
					$.post('orderDetailAction_newOrder.action',function(data){
						 if(data == 1){
							$.messager.alert("提示信息","新单创建成功!","info");
							$("#orderDetailGrid").datagrid("load");
						} 
					});

				} 

				});

		
		}else{
			$.post('orderDetailAction_newOrder.action',function(data){
				 if(data == 1){
					$.messager.alert("提示信息","新单创建成功!","info");
					$("#orderDetailGrid").datagrid("load");
				} 
			});
			
		}
		
	}
	/* function endOrder(){
		
		$.post('orderDetailAction_endOrder.action',function(data){
			 if(data == 1){
				$.messager.alert("提示信息","新单创建成功!","error");
			} 
		});
	} */
	function endOrderWindow(){
		var allrows = $("#orderDetailGrid").datagrid("getRows");
		if(allrows!=""){
			$('#endOrderWindow').window("open");
			var table=$("#orderDetailGrid").datagrid("getRows");//获取当前页的所有行
			var total=0;
			for(var i=0;i<table.length;i++){
			//alert(table[i]['VYpmc']);
			total+=table[i]['totalprice'];
			}
			$("input[name=ordertotalprice]").val(total);
			$('#tableid').combobox({ 

				url:'tableManagerAction_findNoSeat.action',

				 valueField:'id', 

				textField:'id', 
				 required: true,
				 validType: 'length[0,2]' ,
				 message: '请选择桌号' 
			});
		}else{
			$.messager.alert("提示信息","订单没有内容，请先点菜!","error");
		}
		
		
	}
	
	function editOrderWindow(index){
		$('#editOrderWindow').window("open");
		$('#orderDetailGrid').datagrid('selectRow', index);  
		var rows =$("#orderDetailGrid").datagrid("getSelections");
		$("input[name=orderdishid]").val(rows[0].dishes.dishid);
		
		$("input[name=editdishname]").val(rows[0].dishes.dishname);
		$("input[name=num]").val(rows[0].num);
		$("input[name=checktaste]").val(rows[0].taste);
		$("input[name=taste]").val(rows[0].taste);
	}
	function getchange(){
		var totalprice=$("input[name=ordertotalprice]").val();
		var realreceive = $("input[name=realreceivemoney]").val();
		var change =realreceive-totalprice;
		$("input[name=change]").val(change);
		
	}
	
	
	
	//定义一个工具方法，用于将指定的form表单中所有的输入项转为json数据{key:value,key:value}
	$.fn.serializeJson=function(){  
        var serializeObj={};  
        var array=this.serializeArray();
        $(array).each(function(){  
            if(serializeObj[this.name]){  
                if($.isArray(serializeObj[this.name])){  
                    serializeObj[this.name].push(this.value);  
                }else{  
                    serializeObj[this.name]=[serializeObj[this.name],this.value];  
                }  
            }else{  
                serializeObj[this.name]=this.value;   
            }  
        });  
        return serializeObj;  
    };
	
	
	
	
		  function doSearch(value,name){ //用户输入用户名,点击搜素,触发此函数  
			  var dishid=$("input[name=searchtype]").val();
			 	 /* var p=$("#searchtype").serializeJson();
				console.info(p); */
				$("#grid").datagrid("load",{"dishid":dishid});/* 
				$("#searchWindow").window("close"); */
		           
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
		/* editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		}  */
	}, {
		field : 'dishname',
		title : '菜品名称',
		width : 120,
		align : 'center',
		/* editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		} */
	},{
		field : 'unit',
		title : '单位',
		width : 120,
		align : 'center',
		/* editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		} */
	}, {
		field : 'price',
		title : '单价',
		width : 120,
		align : 'center',
		/* editor :{
			type : 'numberbox',
			options : {
				required: true
			}
		} */
	}, {
		field : 'categoryName',
		title : '类别',
		width : 120,
		formatter : fmLevelAJ, 
		align : 'center',
		/* editor :{
			
       		 type: 'combobox',
            options: {
                editable:false,
                required: true,
                valueField: 'id',
                textField: 'name',
                data:GetLevelDTAJ()
                
                 url: 'categoryAction_findAll.action' 
            }
       
		} */
	} ,{  
		field : 'aaa',
		title : '操作',
		width : 120,
		align : 'center',
		formatter : function(val,row,index){ 
			 var str = '<a href="#"  name="opera" class="easyui-linkbutton" onclick="doAdd('+index+')"></a>';  
		      return str;  
			}
		
	}
	
		] 
	];
	//点菜展示
	var orderDetailcolumns = [ [ {
		field : 'dishid',
		title : '菜品编号',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.dishes.dishid;
		}
		/* editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		} */
	},{
		field : 'dishname',
		title : '菜品名称',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.dishes.dishname;
		}
		/* editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		} */
	},{
		field : 'unit',
		title : '单位',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.dishes.unit;
		}
		/* editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		} */
	}, {
		field : 'taste',
		title : '口味',
		width : 120,
		align : 'center',
		/* editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		} */
	}, {
		field : 'price',
		title : '单价',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.dishes.price;
		}
		/* editor :{
			type : 'numberbox',
			options : {
				required: true
			}
		} */
	}, {
		field : 'num',
		title : '数量',
		width : 120,
		align : 'center',
		/* editor :{
			type : 'numberbox',
			options : {
				required: true
			}
		} */
	}, {
		field : 'totalprice',
		title : '总价',
		width : 120,
		align : 'center',
		/* editor :{
			type : 'numberbox',
			options : {
				required: true
			}
		} */
	}, {
		field : 'categoryName',
		title : '类别',
		width : 120,
		formatter : fmLevelAJ, 
		align : 'center',
		formatter : function(data, row, index) {
			return row.dishes.categoryName;
			}
		},{  
			field : 'ccc',
			title : '操作1',
			width : 120,
			align : 'center',
			formatter : function(val,row,index){ 
				 var str = '<a href="#"  name="editOrderDish" class="easyui-linkbutton" onclick="editOrderWindow('+index+')"></a>';  
			      return str;  
				}
			},{  
				field : 'bbb',
				title : '操作2',
				width : 120,
				align : 'center',
				formatter : function(val,row,index){ 
					 var str = '<a href="#"  name="delOrderDish" class="easyui-linkbutton" onclick="doDelete('+index+')"></a>';  
				      return str;  
					}
				}
	] ];
	
	
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		
		// 收派标准数据表格
		$('#grid').datagrid( {
			/////////
			title:'菜单大全',  
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
			
			onLoadSuccess:function(data){  
			    $("a[name='opera']").linkbutton({text:'点菜',plain:true,iconCls:'icon-add'});  
			},
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
		
		
		//收派标准数据表格
		$('#orderDetailGrid').datagrid( {
			/////////
					title:'已点菜单',  
		            iconCls:'icon-ok',  
		            pageList:[1,10,15,20],  
		            nowrap:true,  
		            striped:true,  
		            collapsible:true,  /* 
		            toolbar:"#easyui_toolbar",  */ 
		            url:"dishAction_hasOrderItem.action", //触发此action,带上参数searcValue  
		            loadMsg:'数据加载中......',  
		            fitColumns:true,//允许表格自动缩放,以适应父容器  
		            sortName:'userId',  
		            sortOrder:'asc',  
		            remoteSort:false,  
		            columns : orderDetailcolumns,  
		           /*  pagination : true,  */ 
		            fit:true,
		            rownumbers : true ,
		            border : true,
		            onLoadSuccess:function(data){  
					    $("a[name='delOrderDish']").linkbutton({text:'取消',plain:true,iconCls:'icon-cancel'});  
					    $("a[name='editOrderDish']").linkbutton({text:'修改',plain:true,iconCls:'icon-edit'}); 
					},
			/* onDblClickRow : doDblClickRow,
			onAfterEdit : function(rowIndex, rowData, changes){
				/* console.info(rowData); 
				editIndex = undefined;
				$.post('dishAction_saveOrUpdate.action',rowData,function(data){
					if(data == 0){
						$.messager.alert("提示信息","工作单录入失败!","error");
					}
				});
			} */
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
		
		
		
		// 结账区域窗口
		$('#endOrderWindow').window({
	        title: '选择桌号',
	        width: 400,
	        modal: true,
	        shadow: true,
	        closed: true,
	        height: 150,
	        resizable:false
	    });
		
		// 修改区域窗口
		$('#editOrderWindow').window({
	        title: '结账',
	        width: 400,
	        modal: true,
	        shadow: true,
	        closed: true,
	        height: 400,
	        resizable:false
	    });
		
		$("#btn").click(function(){
			var p=$("#endOrderForm").serializeJson();
			var v=$("#endOrderForm").form("validate");
			if(v){
				$("#endOrderWindow").window("close");
				$.post('orderDetailAction_endOrder.action',p,function(data){
					 if(data == 1){
						
						$.messager.alert("提示信息","结账成功!","info");
						$("#orderDetailGrid").datagrid("load");
					} 
				}); 
			}
		});   
	           
		
		$("#afterdinner").click(function(){
			/* var p=$("#endOrderForm").serializeJson();
			var v=$("#endOrderForm").form("validate"); */
			/* if(v){ */
				/* $("#endOrderWindow").window("close"); */
				$.post('orderDetailAction_saveOrder.action',{},function(data){
					 if(data == 1){
						
						$("#orderDetailGrid").datagrid("load");
						parent.RefreshCloudHomePageTab("餐桌管理");
					} 
				}); 
			/* } */
		}); 
		
		$.extend($.fn.validatebox.defaults.rules, {  
			 integer: {// 验证整数 可正负数  
			               validator: function (value) {  
			                   //return /^[+]?[1-9]+\d*$/i.test(value);  
			  
			                   return /^([+]?[0-9])|([-]?[0-9])+\d*$/i.test(value);  
			               },  
			               message: '请输入整数'  
			           },  
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
<body >

	
	<!-- <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>  -->
	
	<!-- <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div> 
	
	<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>  -->
	<!-- 
	<div data-options="region:'west',title:'West',split:true" style="width:1000px;height:1000px;">
	
	</div>  
	
	<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;height:1000px;"> -->
			
	
<!-- </div>  -->
	<div class="easyui-layout" data-options="fit:true">

		<div data-options="region:'east'" style="width: 800px; padding: 10px">
			
			 <table id="orderDetailGrid">

			</table>
			
			
		</div>
		
		
		
		
		
		
		
		<div data-options="region:'center'" style="padding: 10px">
			<!-- <div region="center" border="false"> -->

			<table id="grid">

			</table>
			<div id="easyui_toolbar" region="north" border="false"
				style="border-bottom: 25px solid #fafafa; padding: 2px 5px; background: #fafafa;">

				<div id="tb" style="float: left;">
					<input id="searchtype" name="searchtype" class="easyui-searchbox" prompt="输入菜单编号"
						searcher="doSearch" style="width: 180px; vertical-align: middle;"></input>
				</div>

				<div class="datagrid-btn-separator"></div>

				<!--
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
                 -->

				<div style="float: left;">
					<font color="blue">选择类别:</font> <input id="category"
						name="category" value="全部分类">
				</div>
				<div style="float: left;margin-left:30px;margin-top:5px">
					<font color="blue">当前桌号:${session.savetableId}</font> 
				</div>
				<br>
				<br>
				<br>
				<!-- <form id="orderDetailForm" action="orderDetailAction_add.action" method="post"> -->
				<input type="hidden" name="itemid">
				<div id="tb" style="float: left;">
					<font color="blue">数量:</font> <input id="num" name="num"
						class="easyui-textbox" value="1">
				</div>
				&nbsp;
				<div class="datagrid-btn-separator"></div>

				<div id="tb" style="float: left;">
					<font color="blue">口味:</font> <input id="taste"
						class="easyui-textbox" name="taste" value="正常">
				</div>
				<!-- </form> -->
				<div class="datagrid-btn-separator"></div>
				<!-- <div style="float: left;">
					<a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit"
						onclick="newOrder()">新单</a>
				</div> -->

				<!-- <div class="datagrid-btn-separator"></div>
				<div style="float: left;">
					<a  class="easyui-linkbutton" plain="true" icon="icon-add"
						onclick="doAdd()">点菜</a>
				</div> -->
				<!-- <div class="datagrid-btn-separator"></div> -->
				<div style="float: left;">
				<!-- <a id="afterdinner" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存菜品</a>  -->
					<a id="afterdinner" href="#" class="easyui-linkbutton" plain="true" icon="icon-ok"
						>保存菜品</a> 
				</div>
			</div>
			</div>
			
	</div>


	<!-- </div> -->
	</div>
	
	
	
	<div class="easyui-window" title="结账" id="endOrderWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="center" style="overflow:auto;padding:5px;" border="false">
				
				<form id="endOrderForm" action="regionAction_edit.action" method="post">
					<table class="table-edit" width="80%" align="center">
					<input type="hidden" name="id"/>
					<input type="hidden" name="ordertotalprice" />
						<tr>
							<td>餐桌号</td>
							<td><input id="tableid" name="tableid" value="请选择桌号"  /></td>
						</tr>
						<!-- <tr>
							<td>订单总额</td>
							<td><input type="text" name="ordertotalprice" readonly="true" class="easyui-validatebox" required="true"/></td>
						</tr>
						<tr>
							<td>实收金额</td>
							<td><input type="text" onblur="getchange()"  name="realreceivemoney" required="true" class="easyui-validatebox"  /></td>
						</tr>
						<tr>
							<td>找零</td>
							<td><input type="text" name="change" readonly="true" class="easyui-validatebox"  required="true"/></td>
						</tr> -->
						
						<!-- <tr>
							<td colspan="1"><a id="afterdinner" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a> </td>
							
						<td colspan="1"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">结账</a> </td>
						</tr> -->
						</table>
				</form>
			</div>
	</div>
	
	
	
	<div class="easyui-window" title="菜单修改" id="editOrderWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="center" style="overflow:auto;padding:5px;" border="false">
				
				<form id="editOrderForm" action="regionAction_edit.action" method="post">
					<table class="table-edit" width="80%" align="center">
					<input type="hidden" name="orderdishid"/>
						<tr class="title">
							<td colspan="2">菜单修改</td>
						</tr>
						<tr>
							<td>菜名</td>
							<td><input type="text" name="editdishname" readonly="true" class="easyui-validatebox" required="true"/></td>
						</tr>
						<tr>
							<td>数量</td>
							<td><input type="text"   name="num" class="easyui-validatebox"  /></td>
						</tr>
						<tr>
							<td>口味</td>
							<input type="hidden" name="checktaste"/>
							<td><input type="text" name="taste"  class="easyui-validatebox" required="true"/></td>
						</tr>
						<tr>
							<td colspan="2"><a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">修改</a> </td>
						</tr>
						<script type="text/javascript">
						$("#btn1").click(function(){
							var p=$("#editOrderForm").serializeJson();
							
							var v=$("#editOrderForm").form("validate");
							if(v){
								$("#editOrderWindow").window("close");
								$.post('orderDetailAction_editOrder.action',p,function(data){
									 if(data == 1){
										
										$.messager.alert("提示信息","修改成功!","info");
										 $("#orderDetailGrid").datagrid("load");
									} 
									
								}); 
								
							}
						});   
						</script>
						
						</table>
				</form>
			</div>
	</div>
	
	
	
	
</body>
</html>