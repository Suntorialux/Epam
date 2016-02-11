<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	${error}
	<form action="registration" method="post">
		Login <input type="text" name="login" /><br /> Password <input
			type="password" name="password" /> <input type="submit"
			value="Registration" />
	</form>
	<p><a href="main">main</a></p>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>