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
			<c:forEach var="sector" items="${hall}">
				<li class="parent"><a>${sector.key} </a>
					<ul>
						<c:forEach var="row" begin="1" end="${sector.value.numberRow}" varStatus="col">
							<li class="parent"><a>Row ${row}</a>
								<ul>
									<c:forEach var="place" begin="1" end="${sector.value.numberPlace}" varStatus="col2">
										<li id="${sector.key}_${row}_${place}" class="parent"><a
											onclick="sendForm('${play.id}_${sector.key}_${row}_${place}_${sector.value.price}')">Place
												${place}</a></li>
									</c:forEach>
								</ul></li>
						</c:forEach>
					</ul></li>
			</c:forEach>
		</ul>
	</div>

	<table>
		<tr><td bgcolor="red" width="40" height="30" ></td><td>is brone</td></tr>
		<tr><td bgcolor="yellow" width="40" height="30"></td><td>is free</td></tr>
	</table>
	
	<c:forEach var="sector" items="${hall}">
		<caption>${sector.key}price: ${sector.value.price} $</caption>
		<table>
			<c:forEach var="row" begin="1" end="${sector.value.numberRow}"
				varStatus="col">
				<tr>
					<c:forEach var="places" begin="1" end="${sector.value.numberPlace}"
						varStatus="col2">
						<jsp:useBean id="place" class="by.gsu.epamlab.model.beans.Place" />
						<jsp:setProperty property="nameSector" name="place"
							value="${sector.key}" />
						<jsp:setProperty property="numberRow" name="place"
							value="${col.count}" />
						<jsp:setProperty property="numberPlace" name="place"
							value="${col2.count}" />
						<jsp:setProperty property="price" name="place"
							value="${sector.value.price}" />
						<jsp:useBean id="booking"
							class="by.gsu.epamlab.model.beans.Booking" />
						<jsp:setProperty property="place" name="booking" value="${place}" />
						<jsp:setProperty property="idPlay" name="booking"
							value="${play.id}" />
						<c:choose>
							<c:when test="${bookings.contains(booking)}">
								<td bgcolor="red" width="40" height="30">${col.count}-${col2.count}</td>
							</c:when>
							<c:otherwise>
								<td bgcolor="yellow" width="40" height="30">${col.count}-${col2.count}</td>
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