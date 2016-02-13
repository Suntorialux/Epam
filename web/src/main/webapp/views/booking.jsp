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
		<caption>${sector.key}</caption>
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
				<li class="parent"><a>${sector.key}</a>
					<ul>
						<c:forEach var="row" begin="1" end="${sector.value.numberRow}"
							varStatus="col">
							<li class="parent"><a>Row ${row}</a>
								<ul>
									<c:forEach var="place" begin="1"
										end="${sector.value.numberPlace}" varStatus="col2">
										<li id="${sector.key}_${row}_${place}" class="parent"><a
											onclick="sendForm('${sector.key}_${row}_${place}')">Place
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

































	<div class="container">


		<div id="form-title" class="form-title field">
			<h2>Booking tickets</h2>
		</div>


		<form action="" method="post">

			<label for="field1"> Select sector </label> <select name="field1"
				id="field1" required="required">
				<option id="field1-1" value="Option 1">Option 1</option>
				<option id="field1-2" value="Option 2">Option 2</option>
				<option id="field1-3" value="Option 3">Option 3</option>
			</select> <label for="field2"> Select row </label> <select name="field2"
				id="field2" required="required">
				<option id="field2-1" value="Option 1">Option 1</option>
				<option id="field2-2" value="Option 2">Option 2</option>
				<option id="field2-3" value="Option 3">Option 3</option>
			</select> <label for="field3"> Select place </label> <select name="field3"
				id="field3" required="required">
				<option id="field3-1" value="Option 1">Option 1</option>
				<option id="field3-2" value="Option 2">Option 2</option>
				<option id="field3-3" value="Option 3">Option 3</option>
			</select> <input type="submit" value="Submit">

		</form>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>