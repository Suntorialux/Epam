<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/jquery.loginPopup.css" />
<script type="text/javascript" src="js/jquery.click.js"></script>
<title>main</title>
</head>
<body>
	<div class="main">
		<div class="content">
			<jsp:include page="header.jsp"></jsp:include>
			${error}
			<table border="1" style="width: 100%">
				<c:forEach items="${playlist}" var="play" varStatus="id">
					<tr>
						<th><a style="cursor: hand"
							onclick="sendForm('${play.value.id}')">${play.value.date}</a></th>
						<th><p style="cursor: hand" onClick="expandit(this)">
								<a>${play.value.title}</a>
							</p> <span style="display: none" style=&{head};>
								${play.value.description} </span></th>
					</tr>
				</c:forEach>
			</table>
			<form id="name" name="send" action='<c:url value="/booking"/>'
				method="post">
				<input id="play" name="idPlay" type="hidden" />
			</form>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>