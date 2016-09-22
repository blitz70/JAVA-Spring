<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Reply Page</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr><td colspan="2" align="center">원글</td></tr>
		<tr >
			<td>번호</td><td>${content.bId}</td>
		</tr>
		<tr >
			<td>날짜</td><td>${content.bDate}</td>
		</tr>
		<tr >
			<td>히트</td><td>${content.bHit}</td>
		</tr>
		<tr >
			<td>이름</td><td>${content.bName}</td>
		</tr>
		<tr >
			<td>제목</td><td>${content.bTitle}</td>
		</tr>
		<tr >
			<td>내용</td><td>${content.bContent}</td>
		</tr>
	</table>
	<br>
	<form action="reply" method="post">
		<input type="hidden" name="bId" value="${content.bId}">
<%-- 		
		<input type="hidden" name="bGroup" value="${content.bGroup}">
		<input type="hidden" name="bStep" value="${content.bStep}">
		<input type="hidden" name="bIndent" value="${content.bIndent}">
 --%>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr><td colspan="2" align="center">답글</td></tr>
			<tr >
				<td>이름</td><td><input type="text" name="bName" size="65"></td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" name="bTitle" size="65"></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea rows="10" cols="50" name="bContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="답변"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="list">목록</a></td>
			</tr>
		</table>
	</form>

</body>
</html>