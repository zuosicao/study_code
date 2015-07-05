<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.beans.Student"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE hmtl>
<head>
<meta charset="utf-8">
</head>
<h1>学生列表展示</h1>
<ul>

	<c:forEach items="${pageStus}" var="stu">
		<li>
			姓名：${stu.name}&nbsp;年龄：${stu.age}
		</li>
	</c:forEach>
</ul>
<img alt="什么鬼" src="resources/images/22.jpg" width="100px">
