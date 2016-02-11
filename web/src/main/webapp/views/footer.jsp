<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="by.gsu.epamlab.model.beans.Constants"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />
<title>footer</title>
<style type="text/css">
.footer {
	/* position: absolute; /* Фиксированное положение */
	left: 0;
	bottom: 0; /* Левый нижний угол */
	width: 100%; /* Ширина слоя */
}
</style>
</head>
<body>
	<fieldset class="footer">
		<%=Constants.DEVELOPER%>
		<a href="mailto:<%=Constants.MAIL_DEVELOPER%>"><%=Constants.MAIL_DEVELOPER%></a>
	</fieldset>
</body>
</html>