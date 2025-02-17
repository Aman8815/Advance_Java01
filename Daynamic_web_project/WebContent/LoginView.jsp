<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Loginctl" method="post">
		<h1 align="center">Login Page</h1>
		<table align="center" width = "5%" border ="1px">
			<center>
				<%
					String msg = (String) request.getAttribute("msg");
				%>
				<%
					if (msg != null) {
				%>
				<h2><%=msg%></h2>
				<%
					}
				%>
			</center>
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
				<th><input type="submit" name="Operation" value="login"></th>
				<th><a href="FirstView.jsp">SingUp</a></th>
			</tr>
		</table>
	</form>
</body>
</html>