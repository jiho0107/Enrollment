<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="enroll.vo.StudentVO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 : 과목리스트 -> 수강생 정보</title>
</head>
<body>
	<%
	ArrayList<StudentVO> list = (ArrayList<StudentVO>)request.getAttribute("list"); %>
	총 수강인원 : <%=list.size() %>명
	<p>
	<% if(!list.isEmpty())
	{ %>
		<table border="1">
			<tr><th>id</th><th>이름</th></tr>
			<%
			for(int i=0; i < list.size(); i++){
				StudentVO student = list.get(i); %>
			<tr>
				<td><%= student.getStuId() %></td>
				<td><%= student.getStuName() %></td>
			</tr>
			<% }%>
		</table>
<% }else{
		out.print("해당 과목을 수강하는 학생이 없습니다.");
	}%>
	
	
</body>
</html>