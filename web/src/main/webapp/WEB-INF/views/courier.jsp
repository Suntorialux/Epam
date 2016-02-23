<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/jquery.loginPopup.css" />
<title>courier</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<form name="selectBooking" action='<c:url value="/courier"/>'
		method="POST">
		<table style="width: 100%">
			<tr align="center">
				<td><input type="submit" name="operation" value="all"
					width="30%"></td>
				<td><select name="idPlay" size="1">
						<c:forEach var="play" items="${playlist}">
							<option value="${play.value.id}">${play.value.date}</option>
						</c:forEach>
				</select> <input type="submit" name="operation" value="play" width="30%">

				</td>
				<td><select name="userLogin" size="1">
						<c:forEach var="login" items="${logins}">
							<option value="${login}">${login}</option>
						</c:forEach>
				</select> <input type="submit" name="operation" value="user" width="30%">

				</td>

				<td><select name="status" size="1">
						<option value="isBooked">isBooked</option>
						<option value="isBought">isBought</option>
				</select> <input type="submit" name="operation" value="status" width="30%">
				</td>
			</tr>
		</table>

	</form>
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
						<form name="changeBooking" action='<c:url value="/courier"/>'
							method="post">
							<input type="hidden" name="idBooking" value="${booking.key}">
							<input type="submit" name="operation" value="change on isBought">
							<input type="submit" name="operation" value="delete">
						</form>
					</c:if></td>
			</tr>

		</c:forEach>
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>