<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean user = (UserBean) session.getAttribute("user");
	%>
	<%
		if (user != null) {
	%>
	<h2><%="Hii ," + user.getFirstName()%></h2>
	<a href="AddUserctl.do">AddUser</a> |
	<a href="UserListctl.do">User List</a> |
	<a href="AddStudentctl.do">AddStudent</a> |
	<a href="StudentList.do">StudentList</a> |
	<a href="MarksViewctl.do">Addstudent</a> |
	<a href="marksListctl.do">StudentMarkslist</a> |
	<a href="Loginctl?operation=logout">Logout</a> |
	<%
		} else {
	%>
	<h2>hii ,Guest</h2>
	<a href="LoginView.jsp">Login</a> |
	<a href="FirstViewctl">SingUp</a> |
	<%
		}
	%>
</body>
</html>