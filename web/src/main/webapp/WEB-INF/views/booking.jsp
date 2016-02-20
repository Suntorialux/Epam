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
	<div id="mainmenu">
		<ul>
			<c:set var = "free" value="free"/>
			<c:forEach var="sector" items="${bookingHall}">
				<li class="parent"><a>${sector.key}</a>
					<ul>
						<c:forEach var="rowBooking" items="${sector.value}"
							varStatus="numRow">
							<li class="parent"><a>Row ${numRow.count}</a>
								<ul>
									<c:forEach var="booking" items="${rowBooking}"
										varStatus="numPlace">
										
										<c:if test="${free eq booking.status}">
											<li class="parent"><a
												onclick="sendForm('${play.id}_${sector.key}_${numRow.count}_${numPlace.count}_${booking.price}')">Place
													${numPlace.count} price: ${booking.price}</a></li>
										</c:if>
									</c:forEach>
								</ul></li>
						</c:forEach>
					</ul></li>
			</c:forEach>
		</ul>
	</div>

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
		<table>
			<caption>${sector.key}</caption>
			<c:forEach var="row" items="${sector.value}" varStatus="numRow">
				<tr>
					<c:forEach var="booking" items="${row}" varStatus="numPlace">
						<c:choose>
							<c:when test="${booking.status == 'brone'}">
								<td bgcolor="red" width="40" height="30">${numRow.count}-${numPlace.count}</td>
							</c:when>
							<c:otherwise>
								<td bgcolor="yellow" width="40" height="30">${numRow.count}-${numPlace.count}</td>
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