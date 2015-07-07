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
    
    <title>My JSP 'validateByXml.jsp' starting page</title>
    
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
  <s:fielderror>
  
  </s:fielderror>
	<s:debug></s:debug>
   <s:form action="validateByXmlAction" theme="simple">
   	<s:token></s:token>
   		<s:text name="usernamLable"></s:text><s:textfield name="userInfo.username"></s:textfield><span></span><br/>
   		<s:text name="passwordLable"></s:text><s:password name="userInfo.password"></s:password><br/>
   		<s:text name="emailLable"></s:text><s:textfield name="userInfo.email"></s:textfield><br/>
   		<s:text name="ageLable"></s:text><s:textfield name="userInfo.age" maxlength="3"></s:textfield><br/>
   		<s:text name="sexLable"></s:text><s:radio list='#{"M":"男","F":"女"}' name="userInfo.sex" ></s:radio><br/>
   		<s:submit value="注册"></s:submit>
   </s:form>
  </body>
</html>
