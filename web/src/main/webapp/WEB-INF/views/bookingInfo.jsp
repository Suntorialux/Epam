<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet" href="../css/jquery.loginPopup.css" />
<title>Order</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>${error}</h3>
	<table border="1" >
		<tr>
			<th>Date: ${play.date}</th>
		</tr>
		<tr>
			<th>Title: ${play.title}</th>
		</tr>
		<tr>
			<th>Sector: ${booking.nameSector}</th>
		</tr>
		<tr>
			<th>Row: ${booking.row}</th>
		</tr>
		<tr>
			<th>Place: ${booking.place}</th>
		</tr>
		<tr>
			<th>Price: ${booking.price}</th>
		</tr>

	</table>
	<form name="book" action='<c:url value="/booking/order"/>' method="POST">
		<input type="hidden" name="date" value="${play.id}">
		<input type="hidden" name="sector" value="${booking.nameSector}">
		<input type="hidden" name="row" value="${booking.row}">
		<input type="hidden" name="place" value="${booking.place}">
		<input type="hidden" name="price" value="${booking.price}">
		<input type="submit" value="Book">
	
	</form>
		
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>