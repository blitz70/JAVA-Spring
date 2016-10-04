<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List</title>
</head>
<body>

	<table width="500"  border="1"  cellpadding="0" cellspacing="0">
		<tr bgcolor="grey">
			<th>Id</th>
			<th>Writer</th>
			<th>Content</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.mId}</td>
				<td>${dto.mWriter}</td>
				<td><a href="view?mId=${dto.mId}"> ${dto.mContent}</a></td>
				<td><a href="delete?mId=${dto.mId}">X</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="center"><a href="writeForm">글 쓰기</a></td>
		</tr>
	</table>

</body>
</html>