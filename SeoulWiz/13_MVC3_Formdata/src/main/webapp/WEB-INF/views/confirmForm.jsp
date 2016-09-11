<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>confirmForm.jsp</h1>
	<form action="board/confirm1" method="get">
		HttpServletRequest class method
		<input type="hidden" name="form_method" value="HttpServletRequest class">
		<br>ID : <input type="text" name="form_id" />
		<br>PW : <input type="password" name="form_pw" />
		<br><input type="submit" />
	</form>
	<hr>
	<form action="board/confirm2" method="get">
		@RequestParam method
		<input type="hidden" name="form_method" value="@RequestParam">
		<br>ID : <input type="text" name="form_id" />
		<br>PW : <input type="password" name="form_pw" />
		<br><input type="submit" />
	</form>
	<hr>

</body>
</html>