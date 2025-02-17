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
	<h1 align="center">Registeration Page</h1>
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
	%>
	<h1 align="center"><%=msg%></h1>
	<%
		}
	%>
	<form action="FirstViewctl" method="post">
		<table align="center">
			<tr>
				<th>FirstName</th>
				<td><input type="text" name="firstName"
					placeholder="Enter the FirstName"></td>
			</tr>
			<tr>
				<th>LastName</th>
				<td><input type="text" name="lastName"
					placeholder="Enter LastName"></td>
			</tr>
			<tr>
				<th>LoginId</th>
				<td><input type="email" name="loginId"
					placeholder="Enter LoginId"></td>
			</tr>
			<tr>
				<th>PassWord</th>
				<td><input type="password" name="password"
					placeholder="Enter Password"></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><input type="text" name="address"
					placeholder="Enter the address">
			</tr>
			<tr>
				<th>Dob</th>
				<td><input type="Date" name="dob" placehoder="Enter dob"></td>
			</tr>
			<tr>
				<th><input type="submit"></th>
			</tr>
		</table>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>