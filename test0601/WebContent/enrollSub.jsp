<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 : 과목 등록</title>
</head>
<body>
	<h3>Subject</h3>
	<form action="enrollSub.do" method="get">
		I   D : <input type="text" name="subId"><br>
		TITLE : <input type="text" name="subTitle"><br>
		# of Students : <input type="text" name="stuNum"><br>
		<input type="submit" value="Enroll">
	</form>
</body>
</html>