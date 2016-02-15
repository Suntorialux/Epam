<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<script language="JavaScript1.2">
	
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
	<table border="1" width="100%" cellpadding="5" align="center">
		<c:forEach items="${playlist}" var="play" varStatus="id">
			<tr>
				<th><a
					href="${pageContext.request.contextPath}/booking?id=${play.value.id}">${play.value.date}</a></th>
				<th><p style="cursor: hand" onClick="expandit(this)">
						<a>${play.value.title}</a>
					</p> <span style="display: none" style=&{head};>
						${play.value.description} </span></th>
			</tr>
		</c:forEach>



	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>