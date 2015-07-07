<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	
	<script type="text/javascript">
		$(function()
		{
			$("form:first").validate(
				{
					rules:
					{
						email:
						{
							required: true,
							email: true
						},
						
						password:
						{
							required:true,
							rangelength:[6,12]
						}
					},
					
					messages:
					{
						email:
						{
							required: "请用输入邮箱地址",
							email: "请输入合格的邮箱"
						},
						
						password:
						{
							required: "密码不能为空",
							rangelength: "密码长度为6-12"
						}
					},
					 
					errorPlacement:function(error,element)
					{
						error.appendTo(element.parent().next().find("b"));
				}
				}
			);
			
		});	
		
	</script>
  </head>
  
  <body>
  <form action="loginAction" method="post" id="myform">
  	<table>
  		<tr>
  			<td align="right">登陆邮箱</td>
  			<td><input type="text" name="user.username" id="email" value="${requestScope.username}"></td>
  			<td id="error"><font color="red"><b>${requestScope.error}</b></font></td>
  		</tr> 
  		<tr>
  			<td align="right">密码：</td>
  			<td><input type="password" name="user.password"></td>
  			<td id="error"><font color="red"><b></b></font></td>
  		</tr>
  		
  	</table>
  	<c:choose>
  			<c:when test="${requestScope.toUrl != null}">
				<input type="hidden" name="toUrl" value="${requestScope.toUrl}"/>
    		</c:when>
   	</c:choose>
  	<input type="checkbox" name="autoLogin" value="autoLogin">两周内自动登陆<br/> 
  	<input type="submit" value="登陆"><br/>
  	<input type="hidden" name="referer" value="${requestScope.referer}">
  </form>
 	还没有账号？<a href="user/register.jsp">[立即注册]</a>
 
  </body>
</html> 
