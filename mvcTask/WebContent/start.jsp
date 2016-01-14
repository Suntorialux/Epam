<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Start</title>
<link rel="stylesheet" href="resources/libs/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	<jsp:useBean id="reader" class="by.gsu.epamlab.services.Reader" />
	<c:set target="${reader}" property="fileName" value="${initParam.filename}" />
	<form name="test" ACTION="controller" method="POST"
	 onClick="for(i=0;i<test.val.length;i++)test.flag[i].value=test.val[i].value;">
	<c:forEach  items="${reader.numbers}" var="number">
		<div>
		<input name="flag" type="checkbox" value="${number.trim()}">&nbsp;
		<c:choose>
			<c:when test="${reader.control eq 'label'}">
				<label for="${number.trim()}">${number.trim()}</label>
				<br>
			</c:when>
			<c:when test="${reader.control eq 'text'}">
				<input name="val" type="text" style="width: 50px" value="${number.trim()}">
				<br>
			</c:when>
			<c:otherwise>${number.trim()}</c:otherwise>
		</c:choose>
		</div>
	</c:forEach>
	<br>
	<input type=hidden name="select">
	<div class="reference">
	<ul>
		<li><a href="JavaScript:sendForm('sum')">Sum</a></li>
		<li><a href="JavaScript:sendForm('min')">Min</a></li>
		<li><a href="JavaScript:sendForm('max')">Max</a></li>
		<li><a href="JavaScript:sendForm('avg')">Avg</a></li>
	</ul>
	</div>
	</form>
	
	
	<script>
		function sendForm(sRef) {
			document.test.select.value=sRef;
			document.test.submit();
		}
	</script>
	
	<script src="resources/libs/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>	
	
	
	
	