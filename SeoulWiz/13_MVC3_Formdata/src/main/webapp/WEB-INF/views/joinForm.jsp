<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>joinForm.jsp</h1>
	<form action="board/join1" method="get">
		@RequestParam method
		<input type="hidden" name="form_method" value="@RequestParam">
		<br>Name : <input type="text" name="form_name" />
		<br>ID : <input type="text" name="form_id" />
		<br>PW : <input type="password" name="form_pw" />
		<br>Email : <input type="text" name="form_email" />
		<br><input type="submit" />
	</form>
	<hr>
	<form action="board/join2" method="get">
		Data object method
		<input type="hidden" name="method" value="Data object">
		<br>Name : <input type="text" name="name" />
		<br>ID : <input type="text" name="id" />
		<br>PW : <input type="password" name="pw" />
<!-- 	<br>Email : <input type="text" name="email" /> works -->
		<br><input type="submit" />
	</form>

</body>
</html>