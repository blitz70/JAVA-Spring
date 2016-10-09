<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>

	<h1>login.jsp</h1>

	<s:authorize access="hasRole('ROLE_ADMIN')">
		<p>Welcome Administrator !</p>
		<c:url var="adminUrl" value="/admin" />
		<a href="${adminUrl}">To Admin</a>
	</s:authorize>
	<s:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
		<p>Login : <s:authentication property="name"/></p>
	</s:authorize>
	<s:authorize access="!hasAnyRole('ROLE_ADMIN','ROLE_USER')">
		<p>Log-out</p>
	</s:authorize>
	
	<c:url var="logoutUrl" value="/my_logout" />
	<a href="${logoutUrl}">Log out</a>

</body>
</html>