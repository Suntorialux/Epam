<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
<link rel="stylesheet" href="resources/libs/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
<div>
${operation} (${numbers}) is ${result}<br>
 <a href="${pageContext.request.contextPath}">Main</a>
</div>
</body>
</html>