<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom login</title>
</head>
<body>

	<h1>loginForm.jsp</h1>
	
	With fail message
	<c:url value="j_spring_security_check" var="loginUrl"/>
	<form action="${loginUrl}" method="post">
		<c:if test="${param.error != NULL}">
			<p>
			Login ERROR!<br>
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != NULL}">
				Message : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</c:if>
			</p>
		</c:if>
		ID : <input type="text" name="j_username" id="" /><br>
		PW : <input type="password" name="j_password" id="" /><br>
		<input type="submit" value="LOGIN" /><br>
	</form>
	<hr>

	JSTL
	<form action="<c:url value="j_spring_security_check" />" method="post">
		ID : <input type="text" name="j_username" id="" /><br>
		PW : <input type="password" name="j_password" id="" /><br>
		<input type="submit" value="LOGIN" /><br>
	</form>
	<hr>

	Simple, works
	<form action="j_spring_security_check" method="post">
		ID : <input type="text" name="j_username" id="" /><br>
		PW : <input type="password" name="j_password" id="" /><br>
		<input type="submit" value="LOGIN" /><br>
	</form>

</body>
</html>