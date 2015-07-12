<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#allContainer
{
width:1082px;
margin:0 auto;
}
#header
{
	border:2px;
	height:200px;
	
}
#content
{
	border:2px;
	min-height: 500px;
}
#footer
{
	border:2px;
	
}
table
{
width:1080px;
}
#menu
{
width:20%;
}
#body
{
widht:80%;
}
</style>
</head>
<body>
<div id="allContainer">
	<table border="1px">
		<tr id="header">
			<td colspan="2"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr id="content">
			<td id="menu"><tiles:insertAttribute name="menu" /></td>
			<td id="body"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr id="footer">
			<td colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</div>
</body>
</html>