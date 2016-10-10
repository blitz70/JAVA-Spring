<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin</title>
</head>
<body>

	<h1>admin.jsp</h1>

	<c:url var="userUrl" value="/user" />
	<a href="${userUrl}">To user</a><br>
	
	<hr>
	<c:url var="logoutUrl" value="/sec_logout" />
	<form action="${logoutUrl}" method="post">
		<s:csrfInput/>
		<input type="submit" value="Log out">
	</form>

</body>
</html>