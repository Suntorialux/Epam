<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.tools.js"></script>
<script type="text/javascript" src="js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<title>booking</title>
<style>
.bg-red {
	background-color: #ff0000;
}

.bg-green {
	background-color: #008900;
}

.bg-blue {
	background-color: #0000ff;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<p>(${play.id}) ${play.date}</p>
	<p>${play.title}</p>
	<p>${play.description}</p>
	<a href="main">main</a>
	<br>

	<table>
		<c:forEach var="i" items="${zale}">
			<tr>
				<c:forEach var="j" items="${i.value}" varStatus="count">

					<c:if test="${j eq 0}">
						<c:set var="bg" scope="page" value="bg-red" />

					</c:if>
					<c:if test="${j eq 1}">
						<c:set var="bg" scope="page" value="bg-blue " />

					</c:if>

					<td class="${bg}" id="${i.key}_${count.count}"
						style="width: 20px; height: 20px"></td>

				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<form id="form" name="send" action="booking" method="POST">
		<input id="place" name="place" type="hidden"> <input
			name="date" value="${date}" type="hidden"> <input
			name="title" value="${title}" type="hidden">

	</form>
	<script type="text/javascript"
		src=" http://code.jquery.com/jquery-1.11.2.js "></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("td").click(function() {
				$(this).toggleClass("bg-blue");

				$("#place").attr("value", $(this).attr("id"));

				$("#form").submit();

			});
		});
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