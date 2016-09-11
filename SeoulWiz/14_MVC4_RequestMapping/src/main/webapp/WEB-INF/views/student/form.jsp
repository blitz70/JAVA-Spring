<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String context = request.getContextPath();
%>

	<h1>form.jsp</h1>
	
	<form action="<%=context %>/studentView" method="post">
	이름 : <input type="text" name="name"><br>
	나이 : <input type="text" name="age"><br>
	학년 : <input type="text" name="gradeNum"><br>
	반 : <input type="text" name="classNum"><br>
	<input type="submit"><br>
	</form>

</body>
</html>