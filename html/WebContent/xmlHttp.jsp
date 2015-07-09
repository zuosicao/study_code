<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	var $ = new Object();
	$.done = function(fun){
		return fun;
	}
	$.get = function(url) {
		var xmlHttp = getXmlHttp();
		if (xmlHttp != null) {
			xmlHttp.onreadystatechange = function()
			{
				if (xmlHttp.readyState == 4) {
					if (xmlHttp.status = 200) {
						//$.done().call(xmlHttp.responseText);
						//var result = document.getElementById("showContent").innerHTML = xmlHttp.responseText;
						
					}
				}
			}
		    xmlHttp.open("GET", url, true);
			xmlHttp.send(null);

			document.getElementById("showContent").innerHTML = xmlHttp.responseText;
		}
		return this;

	};

	
	function getXmlHttp() {
		var xmlHttp = null;
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		} else {
			xmlHttp = new ActiveXObject(Microsoft.XMLHTTP);
		}
		return xmlHttp;
	}
	function init() {
		 $.get("AjaxServlet")
		  .done(function(returnValue)
				 {
			 			var d = 'dd'
				 }); 
		

		/* if (window.XMLHttpRequest)
			{
			  xmlHttp = new XMLHttpRequest();
			}
		else
			{
				xmlHttp = new ActiveXObject(Microsoft.XMLHTTP);
			}
		
		if (xmlHttp != null)
			{
			   xmlHttp.onreadystatechange = onRequstStateChange;   
			   xmlHttp.open("GET","AjaxServlet",true);
			   xmlHttp.send(null);
			  
			   document.getElementById("showContent").innerHTML = xmlHttp.responseText;
			} */
	}

</script>
</head>
<body onload="init();">
	<div id="showContent"></div>
</body>
</html>