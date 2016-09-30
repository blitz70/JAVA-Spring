<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login result</title>
</head>
<body>

	<h1>login.jsp</h1>
	
	<c:choose>
		<c:when test="${pageContext.request.userPrincipal != NULL}">
			<p>Login : ${pageContext.request.userPrincipal.name}</p>
		</c:when>
		<c:otherwise>
			<p>is Log-Out</p>
		</c:otherwise>
	</c:choose>

	<a href="${pageContext.request.contextPath}/j_spring_security_logout">Log out</a><br>
	
</body>
</html>