<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
   <%--  <base href="<%=basePath%>"> --%>
<meta   content="charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
来吧！来吧 
<a href="home">主页</a>
</body>
</html>