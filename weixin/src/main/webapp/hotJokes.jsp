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
    
    <title>冷笑话</title>
     <meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		.pageButton
		{
		background-color: #008DDE;
   		 border: medium none;
   		 border-radius: 10px;
   		 color: #F4F4F4;
    	cursor: pointer;
   		 font-family: inherit;
   		 height: 30px;
    	text-decoration:none;
   		 width: 130px;
   		 display: block;
   		 float: left;
   		 line-height: 30px;
   		 text-align: center;
   		 margin-right: 3px;
		}
	
	</style>
  </head>
  
  <body>
    <div style="line-height: 35px;margin: 10px 5px">
  		<h3 style="color: #269CD2;margin: 0 auto;width: 100px;">轻松笑一笑</h3>
    	<c:forEach items="${jokes}" var="theJoke">
    		<div style="background:#E9F2FB;border-radius: 10px;padding-left: 10px;">
    		<p>${theJoke.content}</p>
    		<c:if test="${theJoke.imgUrl != null}">
    			<img src="${theJoke.imgUrl}" style="margin-bottom: 5px;">
    		</c:if>
    		</div> 
    	</c:forEach>
    </div>
    <div style="width: 270px; margin: 0 auto;">
    	<c:if test="${currPage > 1}">
		    <a class="pageButton" href="coldJoke?pageNum=${currPage - 1}">上一页</a><a class="pageButton" href="coldJoke?pageNum=${currPage + 1}">下一页</a>
    	</c:if>
    	<c:if test="${currPage <= 1}">
		    <a class="pageButton" style="background: #C4CAD1">上一页</a><a class="pageButton" href="coldJoke?pageNum=${currPage + 1}">下一页</a>
    	</c:if>
    </div>
    <br/><br/>
    <p>摘自  “我们爱讲冷笑话”</p>
  </body>
</html>
