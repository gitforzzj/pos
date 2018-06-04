<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<script src="${pageContext.request.contextPath }/js/highcharts/highcharts.js"></script>
        <script src="${pageContext.request.contextPath }/js/highcharts/modules/exporting.js"></script>
<script type="text/javascript">
	$(function(){
		$("#searchbutton").click(function(){
			   var firsttime = $("#firstdatetime").datetimebox('getValue');
			    var secondtime = $("#seconddatetime").datetimebox('getValue');
			    
			    $.post('orderDetailAction_pie.action',{"firsttime":firsttime,"secondtime":secondtime},function(data){
			    	
			    	  var  chart = Highcharts.chart('container', {
			      		chart: {
			      				plotBackgroundColor: null,
			      				plotBorderWidth: null,
			      				plotShadow: false
			      		},
			      		title: {
			      				text: '根据时间查询菜品销量显示'
			      		},
			      		tooltip: {
			      				headerFormat: '{series.name}<br>',
			      				pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
			      		},
			      		plotOptions: {
			      				pie: {
			      						allowPointSelect: true,
			      						cursor: 'pointer',
			      						dataLabels: {
			      								enabled: true,
			      								format: '<b>{point.name}</b>: {point.percentage:.1f} %',
			      								style: {
			      										color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
			      								}
			      						},
			      						states: {
			      								hover: {
			      										enabled: false
			      								}  
			      						},
			      						slicedOffset: 20,         // 突出间距
			      						point: {                  // 每个扇区是数据点对象，所以事件应该写在 point 下面
			      								events: {
			      										// 鼠标滑过是，突出当前扇区
			      										mouseOver: function() {
			      												this.slice();
			      										},
			      										// 鼠标移出时，收回突出显示
			      										mouseOut: function() {
			      												this.slice();
			      										},
			      										// 默认是点击突出，这里屏蔽掉
			      										click: function() {
			      												return false;
			      										}
			      								}
			      						}
			      				}
			      		},
			      		series: [{
			      				type: 'pie',
			      				name: '菜品销售量占比',
			      				data: data
			      		}]
			      	});
			    });
			    
			   
		}); 
	})
	
</script>
</head>
<body>
	<div id="tb" align="center" style="margin-top: 50px;margin-bottom: 50px">
					<input id="firstdatetime" class="easyui-datetimebox"> -- <input id="seconddatetime" class="easyui-datetimebox">
					<a  id="searchbutton" href="#" class="easyui-linkbutton" plain="true" icon="icon-search" >查询</a> 
					
	</div>
					
	 <div id="container" style="min-width:400px;height:400px"></div>
	 <script type="text/javascript">
	  $.post('orderDetailAction_pie.action',{},function(data){
			
			
	        var  chart = Highcharts.chart('container', {
	    		chart: {
	    				plotBackgroundColor: null,
	    				plotBorderWidth: null,
	    				plotShadow: false
	    		},
	    		title: {
	    				text: '菜品月销量显示'
	    		},
	    		tooltip: {
	    				headerFormat: '{series.name}<br>',
	    				pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
	    		},
	    		plotOptions: {
	    				pie: {
	    						allowPointSelect: true,
	    						cursor: 'pointer',
	    						dataLabels: {
	    								enabled: true,
	    								format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	    								style: {
	    										color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	    								}
	    						},
	    						states: {
	    								hover: {
	    										enabled: false
	    								}  
	    						},
	    						slicedOffset: 20,         // 突出间距
	    						point: {                  // 每个扇区是数据点对象，所以事件应该写在 point 下面
	    								events: {
	    										// 鼠标滑过是，突出当前扇区
	    										mouseOver: function() {
	    												this.slice();
	    										},
	    										// 鼠标移出时，收回突出显示
	    										mouseOut: function() {
	    												this.slice();
	    										},
	    										// 默认是点击突出，这里屏蔽掉
	    										click: function() {
	    												return false;
	    										}
	    								}
	    						}
	    				}
	    		},
	    		series: [{
	    				type: 'pie',
	    				name: '菜品销售量占比',
	    				data: data
	    		}]
	    	});
	        
	    	});
	 </script>
      
</body>
</html>