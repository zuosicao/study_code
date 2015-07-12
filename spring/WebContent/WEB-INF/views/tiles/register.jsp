<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<h1>学生注册</h1>

<sf:form method="post" modelAttribute="student" enctype="multipart/form-data" >
	<label for="stu_name">姓名：</label><sf:input path="name" id="stu_name" /><sf:errors path="name" /><br/>
	<label for="stu_num">学号：</label><sf:input path="stuNum" id="stu_num" /><br/>
	<label for="stu_age">年龄：</label><sf:input path="age" id="stu_age"  /><br/>
	<label for="sex_m">男</label><sf:radiobutton path="sex" value="m" id="sex_m"/>
	<label for="stu_f">女</label><sf:radiobutton path="sex" value="f" id="sex_f"/><br/>
	<input type="file" name="image"/>
	<input type="submit" value="提交">
</sf:form>
