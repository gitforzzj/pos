/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-19 07:31:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>z4豪华西餐店</title>\r\n");
      out.write("<!-- 导入jquery核心类库 -->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.8.3.js\"></script>\r\n");
      out.write("<!-- 导入easyui类库 -->\r\n");
      out.write("<link id=\"easyuiTheme\" rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/default.css\">\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<!-- 导入ztree类库 -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ztree/zTreeStyle.css\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ztree/jquery.ztree.all-3.5.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/locale/easyui-lang-zh_CN.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t// 初始化ztree菜单\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tvar setting = {\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tsimpleData : { // 简单数据 \r\n");
      out.write("\t\t\t\t\tenable : true\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tcallback : {\r\n");
      out.write("\t\t\t\tonClick : onClick\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 基本功能菜单加载\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/functionAction_findMenu.action',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tvar zNodes = eval(\"(\" + data + \")\");\r\n");
      out.write("\t\t\t\t$.fn.zTree.init($(\"#treeMenu\"), setting, zNodes);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(msg) {\r\n");
      out.write("\t\t\t\talert('菜单加载异常!');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 系统管理菜单加载\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/json/admin.json',\r\n");
      out.write("\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tvar zNodes = eval(\"(\" + data + \")\");\r\n");
      out.write("\t\t\t\t$.fn.zTree.init($(\"#adminMenu\"), setting, zNodes);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(msg) {\r\n");
      out.write("\t\t\t\talert('菜单加载异常!');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 页面加载后 右下角 弹出窗口\r\n");
      out.write("\t\t/**************/\r\n");
      out.write("\t\twindow.setTimeout(function(){\r\n");
      out.write("\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\ttitle:\"消息提示\",\r\n");
      out.write("\t\t\t\tmsg:'欢迎登录，超级管理员！ <a href=\"javascript:void\" onclick=\"top.showAbout();\">联系管理员</a>',\r\n");
      out.write("\t\t\t\ttimeout:5000\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t},3000);\r\n");
      out.write("\t\t/*************/\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#btnCancel\").click(function(){\r\n");
      out.write("\t\t\t$('#editPwdWindow').window('close');\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//为确定按钮绑定事件\r\n");
      out.write("\t\t$(\"#btnEp\").click(function(){\r\n");
      out.write("\t\t\t//进行表单校验\r\n");
      out.write("\t\t\tvar v = $(\"#editPasswordForm\").form(\"validate\");\r\n");
      out.write("\t\t\tif(v){\r\n");
      out.write("\t\t\t\t//表单校验通过，手动校验两次输入是否一致\r\n");
      out.write("\t\t\t\tvar v1 = $(\"#txtNewPass\").val();\r\n");
      out.write("\t\t\t\tvar v2 = $(\"#txtRePass\").val();\r\n");
      out.write("\t\t\t\tif(v1 == v2){\r\n");
      out.write("\t\t\t\t\t//两次输入一致，发送ajax请求\r\n");
      out.write("\t\t\t\t\t$.post(\"userAction_editPassword.action\",{\"password\":v1},function(data){\r\n");
      out.write("\t\t\t\t\t\tif(data == '1'){\r\n");
      out.write("\t\t\t\t\t\t\t//修改成功，关闭修改密码窗口\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#editPwdWindow\").window(\"close\");\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t//修改密码失败，弹出提示\r\n");
      out.write("\t\t\t\t\t\t\t$.messager.alert(\"提示信息\",\"密码修改失败！\",\"error\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t//两次输入不一致，弹出错误提示\r\n");
      out.write("\t\t\t\t\t$.messager.alert(\"提示信息\",\"两次密码输入不一致！\",\"warning\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction onClick(event, treeId, treeNode, clickFlag) {\r\n");
      out.write("\t\t// 判断树菜单节点是否含有 page属性\r\n");
      out.write("\t\tif (treeNode.page!=undefined && treeNode.page!= \"\") {\r\n");
      out.write("\t\t\tvar content = '<div style=\"width:100%;height:100%;overflow:hidden;\">'\r\n");
      out.write("\t\t\t\t\t+ '<iframe src=\"'\r\n");
      out.write("\t\t\t\t\t+ treeNode.page\r\n");
      out.write("\t\t\t\t\t+ '\" scrolling=\"auto\" style=\"width:100%;height:100%;border:0;\" ></iframe></div>';\r\n");
      out.write("\t\t\tif ($(\"#tabs\").tabs('exists', treeNode.name)) {// 判断tab是否存在\r\n");
      out.write("\t\t\t\t$('#tabs').tabs('select', treeNode.name); // 切换tab\r\n");
      out.write("\t\t\t\tvar tab = $('#tabs').tabs('getSelected'); \r\n");
      out.write("\t\t\t\t$('#tabs').tabs('update', {\r\n");
      out.write("\t\t\t\t    tab: tab,\r\n");
      out.write("\t\t\t\t    options: {\r\n");
      out.write("\t\t\t\t        title: treeNode.name,\r\n");
      out.write("\t\t\t\t        content: content\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t// 开启一个新的tab页面\r\n");
      out.write("\t\t\t\t$('#tabs').tabs('add', {\r\n");
      out.write("\t\t\t\t\ttitle : treeNode.name,\r\n");
      out.write("\t\t\t\t\tcontent : content,\r\n");
      out.write("\t\t\t\t\tclosable : true\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*******顶部特效 *******/\r\n");
      out.write("\t/**\r\n");
      out.write("\t * 更换EasyUI主题的方法\r\n");
      out.write("\t * @param themeName\r\n");
      out.write("\t * 主题名称\r\n");
      out.write("\t */\r\n");
      out.write("\tchangeTheme = function(themeName) {\r\n");
      out.write("\t\tvar $easyuiTheme = $('#easyuiTheme');\r\n");
      out.write("\t\tvar url = $easyuiTheme.attr('href');\r\n");
      out.write("\t\tvar href = url.substring(0, url.indexOf('themes')) + 'themes/'\r\n");
      out.write("\t\t\t\t+ themeName + '/easyui.css';\r\n");
      out.write("\t\t$easyuiTheme.attr('href', href);\r\n");
      out.write("\t\tvar $iframe = $('iframe');\r\n");
      out.write("\t\tif ($iframe.length > 0) {\r\n");
      out.write("\t\t\tfor ( var i = 0; i < $iframe.length; i++) {\r\n");
      out.write("\t\t\t\tvar ifr = $iframe[i];\r\n");
      out.write("\t\t\t\t$(ifr).contents().find('#easyuiTheme').attr('href', href);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t// 退出登录\r\n");
      out.write("\tfunction logoutFun() {\r\n");
      out.write("\t\t$.messager\r\n");
      out.write("\t\t.confirm('系统提示','您确定要退出本次登录吗?',function(isConfirm) {\r\n");
      out.write("\t\t\tif (isConfirm) {\r\n");
      out.write("\t\t\t\tlocation.href = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/userAction_logout.action';\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction RefreshCloudHomePageTab(title) {\r\n");
      out.write("\t　　　　if ($(\"#tabs\").tabs('exists', title)) {\r\n");
      out.write("\t　　　　　　$(\"#tabs\").tabs('select', title);\r\n");
      out.write("\t　　　　　　window.top.Refresh_CloudHomePage_Content.call();\r\n");
      out.write("\t　　　　}\r\n");
      out.write("\t　　}\r\n");
      out.write("\t// 修改密码\r\n");
      out.write("\tfunction editPassword() {\r\n");
      out.write("\t\t//打开修改密码窗口\r\n");
      out.write("\t\t$('#editPwdWindow').window('open');\r\n");
      out.write("\t}\r\n");
      out.write("\t// 版权信息\r\n");
      out.write("\tfunction showAbout(){\r\n");
      out.write("\t\t$.messager.alert(\"宅急送 v1.0\",\"管理员邮箱: zqx@itcast.cn\");\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("\t<div data-options=\"region:'north',border:false\"\r\n");
      out.write("\t\tstyle=\"height:80px;padding:10px;background:url('./images/header_bg.png') no-repeat right;\">\r\n");
      out.write("\t\t<div id=\"sessionInfoDiv\"\r\n");
      out.write("\t\t\tstyle=\"position: absolute;right: 5px;top:10px;\">\r\n");
      out.write("\t\t\t[<strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</strong>]，欢迎你！\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"position: absolute; right: 5px; bottom: 10px; \">\r\n");
      out.write("\t\t\t<a href=\"javascript:void(0);\" class=\"easyui-menubutton\"\r\n");
      out.write("\t\t\t\tdata-options=\"menu:'#layout_north_pfMenu',iconCls:'icon-ok'\">更换皮肤</a>\r\n");
      out.write("\t\t\t<a href=\"javascript:void(0);\" class=\"easyui-menubutton\"\r\n");
      out.write("\t\t\t\tdata-options=\"menu:'#layout_north_kzmbMenu',iconCls:'icon-help'\">控制面板</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"layout_north_pfMenu\" style=\"width: 120px; display: none;\">\r\n");
      out.write("\t\t\t<div onclick=\"changeTheme('default');\">default</div>\r\n");
      out.write("\t\t\t<div onclick=\"changeTheme('gray');\">gray</div>\r\n");
      out.write("\t\t\t<div onclick=\"changeTheme('black');\">black</div>\r\n");
      out.write("\t\t\t<div onclick=\"changeTheme('bootstrap');\">bootstrap</div>\r\n");
      out.write("\t\t\t<div onclick=\"changeTheme('metro');\">metro</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"layout_north_kzmbMenu\" style=\"width: 100px; display: none;\">\r\n");
      out.write("\t\t\t<div onclick=\"editPassword();\">修改密码</div>\r\n");
      out.write("\t\t\t<div onclick=\"showAbout();\">联系管理员</div>\r\n");
      out.write("\t\t\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t\t\t<div onclick=\"logoutFun();\">退出系统</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div data-options=\"region:'west',split:true,title:'菜单导航'\"\r\n");
      out.write("\t\tstyle=\"width:200px\">\r\n");
      out.write("\t\t<div class=\"easyui-accordion\" fit=\"true\" border=\"false\">\r\n");
      out.write("\t\t\t<div title=\"基本功能\" data-options=\"iconCls:'icon-mini-add'\" style=\"overflow:auto\">\r\n");
      out.write("\t\t\t\t<ul id=\"treeMenu\" class=\"ztree\"></ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"系统管理\" data-options=\"iconCls:'icon-mini-add'\" style=\"overflow:auto\">  \r\n");
      out.write("\t\t\t\t<ul id=\"adminMenu\" class=\"ztree\"></ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div data-options=\"region:'center'\">\r\n");
      out.write("\t\t<div id=\"tabs\" fit=\"true\" class=\"easyui-tabs\" border=\"false\">\r\n");
      out.write("\t\t\t<div title=\"消息中心\" id=\"subWarp\"\r\n");
      out.write("\t\t\t\tstyle=\"width:100%;height:100%;overflow:hidden\">\r\n");
      out.write("\t\t\t\t<iframe src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/page_common_home.action\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width:100%;height:100%;border:0;\"></iframe>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div data-options=\"region:'south',border:false\"\r\n");
      out.write("\t\tstyle=\"height:50px;padding:10px;background:url('./images/header_bg.png') no-repeat right;\">\r\n");
      out.write("\t\t<table style=\"width: 100%;\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 300px;\">\r\n");
      out.write("\t\t\t\t\t\t<div style=\"color: #999; font-size: 8pt;\">\r\n");
      out.write("\t\t\t\t\t\t\tz4豪华酒店 | Powered by \r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: *;\" class=\"co1\"><span id=\"online\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"background: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/online.png) no-repeat left;padding-left:18px;margin-left:3px;font-size:8pt;color:#005590;\">在线人数:1</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--修改密码窗口-->\r\n");
      out.write("    <div id=\"editPwdWindow\" class=\"easyui-window\" title=\"修改密码\" collapsible=\"false\" minimizable=\"false\" modal=\"true\" closed=\"true\" resizable=\"false\"\r\n");
      out.write("        maximizable=\"false\" icon=\"icon-save\"  style=\"width: 300px; height: 160px; padding: 5px;\r\n");
      out.write("        background: #fafafa\">\r\n");
      out.write("        <div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("            <div region=\"center\" border=\"false\" style=\"padding: 10px; background: #fff; border: 1px solid #ccc;\">\r\n");
      out.write("               <form id=\"editPasswordForm\">\r\n");
      out.write("\t                <table cellpadding=3>\r\n");
      out.write("\t                    <tr>\r\n");
      out.write("\t                        <td>新密码：</td>\r\n");
      out.write("\t                        <td><input  required=\"true\" data-options=\"validType:'length[4,6]'\" id=\"txtNewPass\" type=\"Password\" class=\"txt01 easyui-validatebox\" /></td>\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                    <tr>\r\n");
      out.write("\t                        <td>确认密码：</td>\r\n");
      out.write("\t                        <td><input required=\"true\" data-options=\"validType:'length[4,6]'\" id=\"txtRePass\" type=\"Password\" class=\"txt01 easyui-validatebox\" /></td>\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                </table>\r\n");
      out.write("               </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div region=\"south\" border=\"false\" style=\"text-align: right; height: 30px; line-height: 30px;\">\r\n");
      out.write("                <a id=\"btnEp\" class=\"easyui-linkbutton\" icon=\"icon-ok\" href=\"javascript:void(0)\" >确定</a> \r\n");
      out.write("                <a id=\"btnCancel\" class=\"easyui-linkbutton\" icon=\"icon-cancel\" href=\"javascript:void(0)\">取消</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
