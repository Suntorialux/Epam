<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<table border="1" cellpadding="1">
	<tr><td>Date: ${play.date}</td>
	</tr>
	<tr><td>Title: ${play.title}</td></tr>
	<tr><td>Sector: ${place.nameSector}</td></tr>
	<tr><td>Row: ${place.numberRow}</td></tr>
	<tr><td>Place: ${place.numberPlace}</td></tr>
	<tr><td>Price: ${place.price}</td></tr>
	
</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>