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
<h1 align = "center">Add Student</h1>
<% String msg = (String)request.getAttribute("msg");
if (msg != null){%>
  <h2 align = "center"><%=msg %></h2>
     <%} %>
	<form action="AddStudentctl.do" method="post">
		<table align="center">
			<tr>
				<th>Name</th>
				<td><input type="text" name="name"
					placeholder="Enter the Name"></td>
			</tr>
			<tr>
				<th>Subject</th>
				<td><input type="text" name="subject"
					placeholder="Enter subject"></td>
			</tr>
			<tr>
				<th>Collage</th>
				<td><input type="text" name="collage"
					placeholder="Enter collage"></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><input type="text" name="address"
					placeholder="Enter the address">
			</tr>
			<tr>
				<th><input type="submit"></th>
			</tr>
			<tr>
			<th><a href = "StudentList.do">studentlist</a></th>
			</tr>
			
		</table>
	</form>
</body>
</html>