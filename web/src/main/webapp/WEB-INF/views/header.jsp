<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="by.gsu.epamlab.model.beans.Constants"%>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.loginPopup.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#togglePopup').loginPopup($('#popup'));
		$('#togglePopup1').loginPopup($('#popup1'));

	});
</script>

<div class="header">
	<c:if test="${user ne null}">
		<div class="wrap">
			<div class="topnav">
				<p>${user.role}:&nbsp;&nbsp;&nbsp;${user.login}</p>
				<a href='<c:url value="/main"/>'>main</a>&nbsp;&nbsp;&nbsp;
				<c:choose>
					<c:when test="${user.role eq 'COURIER'}">
						<a href='<c:url value="/courier"/>'>Courier page</a>
					</c:when>
					<c:otherwise>
						<a href='<c:url value="/myBookings"/>'>MyBookings</a>
					</c:otherwise>
				</c:choose>
				<form name="form1" action='<c:url value="/logout"/>' method="post">
					<a style="float: right" href="JavaScript:document.form1.submit()">Logout</a>
				</form>
			</div>
		</div>
	</c:if>
	<c:if test="${empty user}">
		<div class="wrap">
			<div class="topnav">
				<div class="b-login">
					User: Visitor &nbsp;&nbsp; <a class="b-login__link"
						href="#toLoginPage" id="togglePopup">Login</a> <a
						class="b-login__link" href="#toLoginPage" id="togglePopup1">Registration</a>
					<div class="b-login__popup" id="popup">
						<form action='<c:url value="/login"/>' method="post">
							<label class="b-login__field"> <span
								class="b-login__field__lbl">Login:</span> <input type="text"
								name="login" required="required" />
							</label> <label class="b-login__field"> <span
								class="b-login__field__lbl">Password:</span> <input
								type="password" name="password" required="required" />
							</label>
							<div class="b-login__field">
								<input class="button" type="submit" value="login" name="login" />
							</div>
						</form>
					</div>

					<div class="b-login__popup" id="popup1">
						<form action='<c:url value="/registration"/>' method="post">
							<label class="b-login__field"> <span
								class="b-login__field__lbl">Login:</span> <input type="text"
								name="login" required="required" />
							</label> <label class="b-login__field"> <span
								class="b-login__field__lbl">Password:</span> <input
								type="password" name="password" required="required" />
							</label>
							<div class="b-login__field">
								<input class="button" type="submit" value="registration" />
							</div>
						</form>
					</div>
					<br> <br> <a href='<c:url value="/main"/>'>main</a>
				</div>
			</div>
		</div>
	</c:if>
</div>