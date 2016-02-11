<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="by.gsu.epamlab.model.beans.Constants"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
</head>
<body>
<fieldset>
	<c:if test="${user ne null}">
    <p>${user.role}:&nbsp;&nbsp;&nbsp;${user.login}</p>
    <form name="form1" action="logout" method="post"> 
		<a style="float:right" href="JavaScript:document.form1.submit()">Logout</a>
	</form>
	</c:if>
	<c:if test="${empty user}">

		<p>User:  Visitor  &nbsp;&nbsp;   <a href="login">Login</a>&nbsp;&nbsp;
										  <a href="registration">Registration</a></p>
	</c:if>
</fieldset>
</body>
</html>