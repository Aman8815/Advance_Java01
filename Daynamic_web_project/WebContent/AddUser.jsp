+-<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<%
		if (bean != null) {
	%>
	<h1 align="center">Update User Information</h1>
	<%
		} else {
	%>
	<h1 align="center">Add User Information</h1>
	<%
		}
	%>
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
	%>
	<h1 align="center"><%=msg%></h1>
	<%
		}
	%>
	<form action="AddUserctl.do" method="post">
		<table align="center">
			<tr>
				<td><input type="hidden" name="id"
					value="<%=bean != null ? bean.getId() : " "%>"></td>
			</tr>
			<tr>
				<th>FirstName</th>
				<td><input type="text" name="firstName"
					value="<%=bean != null ? bean.getFirstName() : ""%>"
					placeholder="Enter the FirstName"></td>
			</tr>
			<tr>
				<th>LastName</th>
				<td><input type="text" name="lastName"
					value="<%=bean != null ? bean.getLastName() : ""%>"
					placeholder="Enter LastName"></td>
			</tr>
			<tr>
				<th>LoginId</th>
				<td><input type="email" name="loginId"
					value="<%=bean != null ? bean.getLoginId() : ""%>"
					placeholder="Enter LoginId"></td>
			</tr>
			<tr>
				<th>PassWord</th>
				<td><input type="password" name="password"
					value="<%=bean != null ? bean.getPassword() : ""%>"
					placeholder="Enter Password"></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><input type="text" name="address"
					value="<%=bean != null ? bean.getAddress() : ""%>"
					placeholder="Enter the address">
			</tr>
			<tr>
				<th>Dob</th>
				<td><input type="Date" name="dob"
					value="<%=bean != null ? bean.getDob() : ""%>"
					placehoder="Enter dob"></td>
			</tr>
			<tr>
				<th><input type="submit" name="opration"
					value="<%=bean != null ? "update" : "save"%>"></th>
			</tr>
		</table>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>