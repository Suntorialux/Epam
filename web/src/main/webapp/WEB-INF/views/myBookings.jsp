<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/jquery.loginPopup.css" />
<title>myBookings</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<table border="1">
		<c:if test="${bookings ne null}">
			<tr align="center">
				<td>№ Booking</td>
				<td>User</td>
				<td>Date</td>
				<td>Title play</td>
				<td>Sector</td>
				<td>Row</td>
				<td>Place</td>
				<td>Price</td>
				<td>Status</td>
			</tr>
		</c:if>
		<c:forEach var="booking" items="${bookings}">

			<tr align="center">
				<td><p>${booking.key}</p></td>
				<td>${booking.value.nameUser}</td>
				<td>${playlist.get(booking.value.idPlay).date}</td>
				<td>${playlist.get(booking.value.idPlay).title}</td>
				<td>${booking.value.nameSector}</td>
				<td>${booking.value.row}</td>
				<td>${booking.value.place}</td>
				<td>${booking.value.price}</td>
				<td>${booking.value.status}</td>
				<td><c:if test="${booking.value.status eq 'isBooked'}">
						<form name="changeBooking" action='<c:url value="/myBookings"/>'
							method="post">
							<input type="hidden" name="idBooking" value="${booking.key}">
							<input type="submit" name="operation" value="cancel booking">
						</form>
					</c:if></td>
			</tr>

		</c:forEach>
	</table>
	
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>