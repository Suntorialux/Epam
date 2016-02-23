<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/jquery.loginPopup.css" />
<title>booking</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<p>(${play.id}) ${play.date}</p>
	<p>${play.title}</p>
	<p>${play.description}</p>
	<br>
	
	
	<table>
		<tr>
			<td bgcolor="red" width="40" height="30"></td>
			<td>is brone</td>
		</tr>
		<tr>
			<td bgcolor="yellow" width="40" height="30"></td>
			<td>is free</td>
		</tr>
	</table>

	<c:forEach var="sector" items="${bookingHall}">
		<table border="1">
			<caption>${sector.key}</caption>
			<c:forEach var="row" items="${sector.value}" varStatus="numRow">
				<tr>
					<c:forEach var="booking" items="${row}" varStatus="numPlace">
						<c:choose>
							<c:when test="${booking.status ne 'free'}">
								<td bgcolor="red" width="40" height="30"></td>
							</c:when>
							<c:otherwise>
								<td bgcolor="yellow" width="40" height="30" style="cursor: hand"
												onclick="sendForm('${play.id}_${sector.key}_${numRow.count}_${numPlace.count}_${booking.price}')"></td>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<br>
	</c:forEach>


	<form id="name" name="send" action='<c:url value="/booking/info"/>'
		method="post">
		<input id="place" name="place" type="hidden" />
	</form>
	<script>
		function sendForm(sRef) {
			document.send.place.value = sRef;
			document.send.submit();
		}
	</script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>