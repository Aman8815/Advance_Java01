<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "Header.jsp" %>
	<h1 align="center">Ragistration page</h1>
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
	%>
	<h1 align="center"><%=msg%></h1>
	<%
		}
	%>
	<form action="MarksViewctl.do" method="post">
		<table align="center">
			<tr>
				<th>Name</th>
				<td><input type="text" name="name"
					placeholder="Enter your name"></td>
			</tr>
			<tr>
				<th>Physics number</th>
				<td><input type="number" name="physics"
					placeholder="Enter physics number"></td>
			</tr>
			<tr>
				<th>Chemestry number</th>
				<td><input type="number" name="chemestry"
					placeholder="Enter chemestry number"></td>
			</tr>
			<tr>
				<th>maths number</th>
				<td><input type="number" name="maths"
					placeholder="Enter maths number"></td>
			</tr>
			<tr>
				<th><input type="submit"></th>
				<th><a href = "marksListctl.do" >Studentlist</a>
			</tr>

		</table>
	</form>
</body>
</html>