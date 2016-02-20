<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/jquery.loginPopup.css" />

<script>
	
var ns6=document.getElementById&&!document.all?1:0
var head="display:''"
var folder=''
function expandit(curobj){
folder=ns6?curobj.nextSibling.nextSibling.style:document.all[curobj.sourceIndex+1].style
if (folder.display=="none")
folder.display=""
else
folder.display="none"
}

</script>
<title>main</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	${error}
	<table border="1" style="width: 100%">
		<c:forEach items="${playlist}" var="play" varStatus="id">
			<tr>
				<th><a style="cursor: hand" onclick="sendForm('${play.value.id}')">${play.value.date}</a></th>
				<th><p style="cursor: hand" onClick="expandit(this)">
						<a>${play.value.title}</a>
					</p> <span style="display: none" style=&{head};>
						${play.value.description} </span></th>
			</tr>
		</c:forEach>



	</table>
	
	
	<form id="name" name="send" action='<c:url value="/booking"/>' method="post">
		<input id="play" name="ID" type="hidden" />
	</form>
	<script>
		function sendForm(sRef) {
			document.send.ID.value = sRef;
			document.send.submit();
		}
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>