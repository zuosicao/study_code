<%@ page import="com.web.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>学生列表展示</h1>
<ul>
	<c:forEach items="${pageStus}" var="stu">
		<li>
			姓名：${stu.name}&nbsp;年龄：${stu.age}
		</li>
	</c:forEach>
</ul>
<img alt="什么鬼" src="resources/images/22.jpg" width="100px">
</body>
</html>