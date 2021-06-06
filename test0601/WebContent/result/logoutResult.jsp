<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOut</title>
</head>
<body>
	${id } : logout!!
	<%
		session.invalidate();
	%>
	<p>
	<a href="/test0601/index.jsp">HOME</a>
</body>
</html>