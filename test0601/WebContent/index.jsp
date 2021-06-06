<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h3>YongIn LMS</h3>
	<form action="login.do" method="post"> 
		I      D : <input type="text" name="id"><br>
		PASSWORD : <input type="password" name="pwd"><br>
		<input type="radio" name="person" value="prof">Professor
		<input type="radio" name="person" value="student">Student
		<input type="submit" value="LogIn">
	</form>
</body>
</html>