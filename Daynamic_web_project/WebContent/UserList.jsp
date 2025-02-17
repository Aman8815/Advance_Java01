<%@page import="com.rays.bean.UserBean"%>
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
	<h1 align="center">User List</h1>
	<form action="UserListctl.do" method="post">
		<table>
			<tr>
				<th>First Name</th>
				<td><input type="text" name="firstName"
					placeholder="search by firstName"></td>
				<th>Last Name</th>
				<td><input type="text" name="lastName"
					placeholder="search by lastName"></td>
				<th>Address</th>
				<td><input type="text" name="address"
					placeholder="search by adress"></td>
				<th>LoginId</th>
				<td><input type="text" name="loginId"
					placeholder="search by loginid"></td>
				<td>&nbsp;<input type="submit" name="operation" value="search"></td>
			</tr>
		</table>
		<table align="center" width="100%" border="1px">
			<tr style="background-color: red">
				<th>Select</th>
				<th>Id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Dob</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>

			<%
				List list = (List) request.getAttribute("list");
				int pageNo = (int) request.getAttribute("pageNo");
				int pageSize = (int) request.getAttribute("pageSize");
				Iterator it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr>
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href="AddUserctl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table align="center">
			<tr>
				<td><input type="submit" name="operation" value="previous"
					<%=pageNo == 1 ? "disabled" : ""%>></td>
				<td><input type="submit" name="operation" value="delete"></td>
				<td align="right"><input type="submit" name="operation"
					value="next" <%=list.size() == 0 ? "disabled" : ""%>></td>
			</tr>
		</table>
		<input type="text" name="pageNo" value="<%=pageNo%>"> <input
			type="text" name="pageSize" value="<%=pageSize%>">
	</form>
</body>
</html>