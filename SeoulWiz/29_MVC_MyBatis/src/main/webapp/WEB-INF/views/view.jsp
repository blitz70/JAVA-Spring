<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>View</title>
</head>
<body>

	<table width="500"  border="1"  cellpadding="0" cellspacing="0">
		<tr>
			<td>아이디</td>
			<td>${view.mId}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${view.mWriter}</td>
		</tr>
		<tr><td colspan="2">내용<td></tr>
		<tr>
			<td colspan="2"><textarea name="mContent"  rows="5" cols="50">${view.mContent}</textarea></td>
		</tr>
		<tr>
			<td><a href="list">목록</a></td>
		</tr>
	</table>


</body>
</html>