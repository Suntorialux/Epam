<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />

<title>booking</title>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<p>(${play.id}) ${play.date}</p>
	<p>${play.title}</p>
	<p>${play.description}</p>
	<a href="main">main</a>
	<br>


	<c:forEach var="sector" items="${hall}">
		<caption>${sector.key}     price: ${sector.value.price} $</caption>
		<table>
			<c:forEach var="row" begin="1" end="${sector.value.numberRow}"
				varStatus="col">
				<tr>

					<c:forEach var="place" begin="1" end="${sector.value.numberPlace}"
						varStatus="col2">

						<td bgcolor="yellow" width="30" height="30">${col.count}-${col2.count}</td>

					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<br>
	</c:forEach>


	<div id="mainmenu">
		<ul>
			<c:forEach var="sector" items="${hall}">
				<li class="parent"><a>${sector.key} </a>
					<ul>
						<c:forEach var="row" begin="1" end="${sector.value.numberRow}"
							varStatus="col">
							<li class="parent"><a>Row ${row}</a>
								<ul>
									<c:forEach var="place" begin="1"
										end="${sector.value.numberPlace}" varStatus="col2">
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


	<form id="name" name="send" action="order" method="post">
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