<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>Welcome</title>
</head>
<body>
<h3>Welcome: ${user.name}</h3>
Your role is ${user.role}.
<br>
<c:if test="${user.role eq 'ADMIN'}">
	<h4>my respect!</h4>
</c:if>
<p>
<a href="<c:url value='/'/>">Back</a>
</body>
</html>
