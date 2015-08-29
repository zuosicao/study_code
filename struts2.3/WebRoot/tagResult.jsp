<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri = "/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tagResult.jsp' starting page</title>
    
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
   	<s:textfield key="label" name="state" value="ca"/>
   	<s:property value="name"/>
   	<s:debug></s:debug>
   	<s:property value="sex"/>
   	<s:iterator value="list" var="theString">
   		<p><s:property value="#theString.length()"/></p>
   	</s:iterator>
   	<s:iterator value="persons" var="thePerson" status="stat">
   		<p>
   		<s:property value="#stat.first"/>
   		<s:property value="#thePerson.c"/></p>
   	</s:iterator>
   		<s:property value="#session.se"/>
   		<s:property value="#request.req"/>
   		<s:property value="#fib =:[#this==0 ? 0 : #this==1 ? 1 : #fib(#this-2)+#fib(#this-1)], #fib(22)" />
  </body>
</html>
