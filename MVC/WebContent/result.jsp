<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<link rel="stylesheet" href="resources/libs/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
${operation} 
 (
<c:forEach  items="${flags}" var="flag">
 ${flag}, 
</c:forEach>
) is
 ${result}<br>
 <a href="/MVC/">Main</a>
</body>
</html>