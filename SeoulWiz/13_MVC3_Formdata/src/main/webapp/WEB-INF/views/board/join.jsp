<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>join.jsp</h1>
	${model_method} method<br>
	Name is ${model_member.name}<br>
	ID is ${model_member.id}<br>
	Password is ${model_member.pw}<br>
	Email is ${model_member.email}<br>

</body>
</html>