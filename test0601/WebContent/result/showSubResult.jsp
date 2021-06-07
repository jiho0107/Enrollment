<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="enroll.vo.SubjectVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교수 : 등록한 과목 리스트</title>
</head>
<body>
<%
	ArrayList<SubjectVO> subjects = (ArrayList<SubjectVO>)request.getAttribute("subjects");
	if(!subjects.isEmpty()){
	%>
	<table border="1">
		<tr>
			<th>과목번호</th><th>과목명</th><th>최대인원</th><th>수강인원</th>
		</tr>
		<%
			for(int i=0; i < subjects.size(); i++){
				SubjectVO subject = subjects.get(i);%>
		<tr>
			<td><a href="stuInfo.do?subId=<%=subject.getId()%>&subName=<%=subject.getName()%>"><%= subject.getId() %></a></td>
			<td><%= subject.getName() %></td>
			<td><%= subject.getCount() %></td>
			<td><%= subject.getNum() %></td>
		</tr>
		<% } %>
	</table>
	<% }
	else{
			out.print("교수님이 등록한 과목이 없습니다.");
		}%>
	<p>
	<a href="prof_menu.jsp">Menu</a>
</body>
</html>