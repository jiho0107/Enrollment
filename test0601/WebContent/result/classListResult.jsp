<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="enroll.vo.EnrollVO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 : 수강 신청한 과목 리스트</title>
</head>
<body>
	<%
	ArrayList<EnrollVO> lists = (ArrayList<EnrollVO>)request.getAttribute("lists");
	if(!lists.isEmpty()){
	%>
	<table border=1>
		<tr>
			<th>과목번호</th><th>과목명</th>
		</tr>
		<%
			for(int i=0; i < lists.size(); i++){
				EnrollVO enroll = lists.get(i); %>
		<tr>
				<td><%= enroll.getSubId() %></td>
				<td><%= enroll.getStuId() %></td>
		</tr>
		<% } %>
	</table>
	<%}else{ 
		out.println("학생이 수강 신청한 과목이 없습니다.");
	}
	%>
	<p>
	<a href="stu_menu.jsp">Menu</a>
</body>
</html>