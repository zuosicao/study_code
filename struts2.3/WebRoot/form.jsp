<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'form.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
  <s:debug></s:debug>
   <s:form theme="simple" onsubmit="return haha();">
   	姓名：<s:textfield name="username"></s:textfield>
   	<s:checkboxlist list="lists" name="sex" listKey="key" listValue="value"></s:checkboxlist>
   	<s:checkboxlist list="#{'a':'中文','b':'英文'}" name="test"></s:checkboxlist>
   	<s:submit value="提交"></s:submit>
   </s:form>
   <s:property value="@cong.ruan.action.Form@HAHA"/>
  </body>
</html>
