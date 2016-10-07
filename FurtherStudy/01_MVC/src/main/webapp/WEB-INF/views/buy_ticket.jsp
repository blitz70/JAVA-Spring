<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buy Ticket</title>
</head>
<body>

	<p>buy_ticket.jsp</p>
	<p>카드 결제</p>
	
	<form action="buy_ticket_card">
		고객 아이디 : <input type="text" name="consumerId" /><br>
		티켓 구매수 : <input type="text" name="amount" /><br>
		<input type="submit" value="구매"><br>
	</form>

</body>
</html>