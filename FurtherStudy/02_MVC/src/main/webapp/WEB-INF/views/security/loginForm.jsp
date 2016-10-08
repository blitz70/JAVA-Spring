<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginForm</title>
</head>
<body>

	<h1>loginForm.jsp</h1>
	
	<c:url var="loginUrl" value="j_spring_security_check" />
	<form action="${loginUrl}" method="post">
		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
		ID : <input type="text" name="j_username" id="" /><br>
		PW : <input type="password" name="j_password" id="" /><br>
		<input type="submit" value="LOGIN" /><br>
	</form>
	
</body>
</html>