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
	var tablestatusid;
	
	function doAdd(index){
		//获得选中的行对象
		$('#grid').datagrid('selectRow', index);  
	   	 var rows = $("#grid").datagrid("getSelections");
	   	 var id = rows[0].id;
	   	 
	   	 if(rows.length == 1){
	   	
	           	 $.post('tableManagerAction_add.action',{"id":id},function(data){
	       				if(data == -1){
	       					$.messager.alert("提示信息","开桌失败!","error");
	       					
	       				}
	       					$("#grid").datagrid("load");
	       		});
	   		
	   	} else{
	   		$.messager.alert("提示信息","请选择一行!","warning");
	   	}
			
	}
	
	function orderDish(index){
		//判断“系统管理”选项卡是否存在
		$('#grid').datagrid('selectRow', index);  
	   	 var rows = $("#grid").datagrid("getSelections");
	   	 var id = rows[0].id;
	   	var oid = rows[0].orderNo;
	   	 //保存餐台的id
	   	$.post('tableManagerAction_saveTableId.action',{"id":id,"oid":oid},function(data){});
	   	 //点菜创建新单
	   	 if(oid!=null){
	   		$.post('orderDetailAction_newOrder.action',function(data){});
	   	 }
	   
	   	
		var e = self.parent.$("#tabs").tabs("exists","点菜");
		if(e){
			//已经存在，选中就可以
			self.parent.$("#tabs").tabs("select","点菜");
			  var tab=self.parent.$('#tabs').tabs('getSelected');//获取当前选中tabs  
			    var index = self.parent.$('#tabs').tabs('getTabIndex',tab);//获取当前选中tabs的index  
			    self.parent.$('#tabs').tabs('close',index);//关闭对应index的tabs  
		}
			//调用tabs对象的add方法动态添加一个选项卡
			self.parent.$("#tabs").tabs("add",{
				title:'点菜',
				iconCls:'icon-edit',
				closable:true,
				content:'<iframe frameborder="0" height="100%" width="100%" src="page_base_ordering.action"></iframe>'
			});
		
	}

	function cleantable(index){
		//获得选中的行对象
		$('#grid').datagrid('selectRow', index);  
	   	 var rows = $("#grid").datagrid("getSelections");
	   	 var id = rows[0].id;
	   	 if(rows.length == 1){
	   	
	           	 $.post('tableManagerAction_cleanTable.action',{"id":id},function(data){
	       				if(data == -1){
	       					$.messager.alert("提示信息","清桌失败!","error");
	       					
	       				}
	       					$("#grid").datagrid("load");
	       		});
	   		
	   	} else{
	   		$.messager.alert("提示信息","请选择一行!","warning");
	   	}
			
	}
	

	function endOrderWindow(index){
		
		//获得选中的行对象
		$('#grid').datagrid('selectRow', index);  
	   	 var rows = $("#grid").datagrid("getSelections");
	   	 var id = rows[0].id;
	   	 if(rows.length == 1){
	   			$('#endOrderWindow').window("open");
	   			$("input[name=tableid]").val(rows[0].tableNo);
	   			$("input[name=oid]").val(rows[0].orderNo);
	   			 $("#orderDetailGrid").datagrid("load",{"oid":rows[0].orderNo});
	   			
	   			/*
	   			$("input[name=tableid]").val(rows[0].tableNo);
	           	 $.post('tableManagerAction_add.action',{"id":id},function(data){
	       				if(data == -1){
	       					$.messager.alert("提示信息","开桌失败!","error");
	       					
	       				}
	       					$("#grid").datagrid("load");
	       		}); */
	   		
	   	} else{
	   		$.messager.alert("提示信息","请选择一行!","warning");
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
			  var seatnum=$("input[name=searchtype]").val();
		  	  if(seatnum=="输入就餐人数"){
		  		seatnum=0;
		  	  }
			 	 /* var p=$("#searchtype").serializeJson();
				console.info(p); */
		  	
			$("#grid").datagrid("load",{"seatnum":seatnum,"statusid":tablestatusid});
				/* 
				$("#searchWindow").window("close"); */
		           
		    }  
		
   
		  
	
	//工具栏
	var toolbar ='#easyui_toolbar'; 
	// 定义列
	var columns = [ [ {
		field : 'tableNo',
		title : '餐桌号',
		width : 120,
		align : 'center',
		/* editor :{
			type : 'validatebox',
			options : {
				required: true
			}
		}  */
	}, {
		field : 'seatnum',
		title : '座位',
		width : 120,
		align : 'center',
		
	}, {
		field : 'tableStatusName',
		title : '餐桌状态',
		width : 120,
		formatter : function(data,row, index){
			if(row.tableStatus==null){
				return "空闲";
			}else{
				return row.tableStatus.statusName;
			}
			
		},
		align : 'center',
		
	} , {
		field : 'orderNo',
		title : '订单号',
		width : 120,
		align : 'center'
	},{
		field : 'tableOrderTime',
		title : '开桌时间',
		width : 120,
		align : 'center'
	},{  
		field : 'aaa',
		title : '操作',
		width : 120,
		align : 'center',
		formatter : function(data,row,index){ 
			if(row.tableStatus==null){
				var str = '<a href="#"  name="opera" class="easyui-linkbutton" onclick="doAdd('+index+')"></a>';  
			      return str; 
			}else{
				if(row.tableStatus.statusid=="3"){
					var str = '<a href="#" id="orderDish" name="orderdish" class="easyui-linkbutton" onclick="orderDish('+index+')"></a>  <a href="#"  name="paymoney" class="easyui-linkbutton" onclick="endOrderWindow('+index+')"></a>';  
				      return str;  
				}else if(row.tableStatus.statusid=="2"){
					var str = '<a href="#" id="orderDish" name="orderdish" class="easyui-linkbutton" onclick="orderDish('+index+')"></a>';  
				      return str;  
				    
				}else if(row.tableStatus.statusid=="1"){
					var str = '<a href="#"  name="opera" class="easyui-linkbutton" onclick="doAdd('+index+')"></a>';  
				      return str;  
				}else{
					var str = '<a href="#"  name="cleantable" class="easyui-linkbutton" onclick="cleantable('+index+')"></a>';  
				      return str;  
				}
			}
			
			 
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
		/* formatter : function(data, row, index) {
			alert(data);
		} */
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
		/* formatter : fmLevelAJ,  */
		align : 'center',
		formatter : function(data, row, index) {
			$("input[name=ordertotalprice]").val(row.order.ordertotalprice);
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
		            url:"tableManagerAction_pageQuery.action", //触发此action,带上参数searcValue  
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
			
			onDblClickRow : doDblClickRow,
			
			
			
			onLoadSuccess:function(data){  
			    $("a[name='opera']").linkbutton({text:'开桌',plain:true,iconCls:'icon-add'});  
			    $("a[name='paymoney']").linkbutton({text:'结账',plain:true,iconCls:'icon-ok'}); 
			    $("a[name='cleantable']").linkbutton({text:'清桌',plain:true,iconCls:'icon-cancel'}); 
			    $("a[name='orderdish']").linkbutton({text:'点菜',plain:true,iconCls:'icon-edit'}); 
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
		            url:"orderAction_NoPayOrderItem.action", //触发此action,带上参数searcValue  
		            loadMsg:'数据加载中......',  
		            fitColumns:true,//允许表格自动缩放,以适应父容器  
		            sortName:'userId',  
		            sortOrder:'asc',  
		            remoteSort:false,  
		            columns:orderDetailcolumns,  
		            pagination : true,  
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
		
		window.top["Refresh_CloudHomePage_Content"] = function () {
		　	　window.location.reload();
		　　}; 
		
		$('#category').combobox({ 

			url:'tableStatusAction_findAll.action', 

			valueField:'statusid', 

			textField:'statusName',
			
			onSelect: function (data) {
				
				  var seatnum=$("input[name=searchtype]").val();
				 	 /* var p=$("#searchtype").serializeJson();
					console.info(p); */
					
					if(seatnum=='输入就餐人数'){
						seatnum=0;
					}
					tablestatusid=data.statusid;
					$("#grid").datagrid("load",{"seatnum":seatnum,"statusid":data.statusid});/* 
				/* $('#grid').datagrid( {
	                url: "dishAction_findByCategoryId.action?category.id="+data.id
				
				}); */
			}
		});
		
		
		
		// 结账区域窗口
		$('#endOrderWindow').window({
	        title: '结账',
	        width: 1000,
	        modal: true,
	        shadow: true,
	        closed: true,
	        height: 600,
	        resizable:false
	    });
		
		/* var jq = top.jQuery;

		if (jq("#tabs").tabs('exists', '一级菜单4')){
		    jq("#tabs").tabs('select','一级菜单4');
		} else {
		    var content = '<iframe scrolling="auto" frameborder="0"  src="http://www.baidu.com" style="width:100%;height:100%;"></iframe>';
		    jq("#tabs").tabs('add',{
		        title:'一级菜单4',
		        content:content,
		        closable:true
		});
		} */
		
		
		
		$("#btn").click(function(){
			
			var p=$("#endOrderForm").serializeJson();
			var v=$("#endOrderForm").form("validate");
			if(v){
				$("#endOrderWindow").window("close");
				$.post('orderAction_endOrder.action',p,function(data){
					 if(data == 1){
						
						$.messager.alert("提示信息","结账成功!","info");
						$("#grid").datagrid("load");
					} 
				}); 
			}
			
			
			
		});   
	           
		$.extend($.fn.validatebox.defaults.rules, {  
			integer:{
		          validator:function(value,param){
		            return /^[+]?[0-9]\d*$/.test(value);
		          },
		          message: '找零不能为负'
		        }
			}
		); 
		
		
	});

	
	
	
	
	function doDblClickRow(rowIndex, rowData){
		$('#grid').datagrid('beginEdit',rowIndex);
		editIndex = rowIndex;
	}
</script>
</head>
<body >

	
	<div class="easyui-layout" data-options="fit:true">

		
		
		<div data-options="region:'center'" style="padding: 10px">
			<!-- <div region="center" border="false"> -->

			<table id="grid">

			</table>
			<div id="easyui_toolbar" region="north" border="false"
				style="border-bottom: 25px solid #fafafa; padding: 2px 5px; background: #fafafa;">

				<div id="tb" style="float: left;">
					<input id="searchtype" name="searchtype" class="easyui-searchbox" prompt="输入就餐人数"
						searcher="doSearch" style="width: 180px; vertical-align: middle;"></input>
				</div>

				<div class="datagrid-btn-separator"></div>

			

				<div style="float: left;">
					<font color="blue">选择餐桌状态:</font> <input id="category"
						name="category" value="全部">
				</div>
				
			</div>
			</div>
			
	</div>


	<!-- </div> -->
	</div>
	
	
	
	<div class="easyui-window" title="结账" id="endOrderWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div data-options="region:'south'" style="width: 800px; height:400px;padding: 10px">
			
			 <table id="orderDetailGrid">
				
			</table>
			
			
		</div>
		<div data-options="region:'center'" style="height:100;padding: 10px">
				
				<form id="endOrderForm" action="regionAction_edit.action" method="post">
					<table class="table-edit" width="80%" align="center">
					<input type="hidden" name="oid"/>
						
						<tr>
							<td>餐桌号</td>
							<td><input id="tableid" name="tableid" readonly="true" /></td>
						
							<td>订单总额</td>
							<td><input type="text" name="ordertotalprice" readonly="true" class="easyui-validatebox" required="true"/></td>
						</tr>
						<tr>
							<td>实收金额</td>
							<td><input type="text" onblur="getchange()"  name="realreceivemoney" required="true" class="easyui-validatebox"  /></td>
						
							<td>找零</td>
							<td><input type="text" name="change" readonly="true" class="easyui-validatebox"  data-options="validType:'integer'"/></td>
						</tr>
						<tr>
							<td colspan="2"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">结账</a> </td>
						</tr>
						<!-- <script type="text/javascript">
									$(function(){
										$("#edit").click(function(){
											var v=$("#endOrderForm").form("validate");
											if(v){
												$("#endOrderForm").submit();
											}
										});
									})
						</script> -->
						
						</table>
				</form>
			</div>
	</div>
	
	 <script type="text/javascript">
					$(function(){
						//页面加载完成后，为上面的按钮绑定事件
						$("#orderDish").click(function(){
							
						});
					});
				</script>
	
	
</body>
</html>