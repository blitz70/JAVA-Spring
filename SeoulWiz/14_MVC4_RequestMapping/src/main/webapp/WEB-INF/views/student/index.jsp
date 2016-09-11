<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>index.jsp</h1>
	
	<form action="student1" method="get">
		Get
		<br>Student Id : <input type="text" name="id">
		<br><input type="submit">
	</form>
	<br>
	<form action="student1" method="post">
		Post
		<br>Student Id : <input type="text" name="id">
		<br><input type="submit">
	</form>
	<hr>
	
	<form action="student2" method="get">
		Get
		<br>Student Id : <input type="text" name="id">
		<br><input type="submit">
	</form>
	<br>
	<form action="student2" method="post">
		Post
		<br>Student Id : <input type="text" name="id">
		<br><input type="submit">
	</form>

</body>
</html>