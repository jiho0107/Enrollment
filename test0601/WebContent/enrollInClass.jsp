<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="enroll.vo.SubjectVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 : 교과목 번호 입력/조회</title>
</head>
<body>
	<h3>Subject</h3>
	<form action="subSearch.do">
		ID : <input type="text" name="subId">
		<input type="submit" value="Search"><br>
	</form>
	<p>
	<%
	SubjectVO subject = (SubjectVO)request.getAttribute("subject");
	String msg = (String)request.getAttribute("msg");
	if(msg != null && msg.equals("true"))
	{%>
		${subject.id}  ${subject.name}
		<form action="enroll.do">
			<input type="hidden" name="subId" value="${subject.id }">
			<input type="submit" value="Enrollment">
		</form>
	<% 
	} else if(msg != null && msg.equals("false")){
		out.println("해당 id의 과목이 존재하지 않습니다.");
	} %>
	<a href="stu_menu.jsp">Menu</a>
</body>
</html>