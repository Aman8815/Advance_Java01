
<%@page import="com.rays.bean.StudentBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp"%>
	<h1 align="center">Strudent List</h1>
	<form action="StudentList.do" method="post">
		<table align="center" width="100%" border="1px">
			<tr style="background-color: red">
			<th>Select</th>
			<th>ID</th>
			<th>Name</th>
			<th>Subject</th>
			<th>Collage</th>
			<th>Address</th>
			</tr>
			<% List list = (List)request.getAttribute("list");
			    StudentBean bean = new StudentBean();
			Iterator it = list.iterator();
			  while(it.hasNext()){
				  bean = (StudentBean)it.next();
			%>
			<tr>
			<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
			<td><%=bean.getId()%></td>
			<td><%=bean.getName() %></td>
			<td><%=bean.getSubject() %></td>
			<td><%=bean.getCollage() %></td>
			<td><%=bean.getAddress() %></td>
			</tr>
			<%} %>
		</table>
		<table>
				<tr>
					<input type="submit" name="operation" value="delete">
				</tr>
			</table>
		
		</body>
</html>