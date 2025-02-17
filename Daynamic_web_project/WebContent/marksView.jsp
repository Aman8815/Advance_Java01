<%@page import="com.rays.bean.MarksheetBean"%>
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
<%@ include file = "Header.jsp" %>
<h1 align = "center">Student Result List</h1>
<% List list = (List)request.getAttribute("list"); %>
<table align = "center" width = "100%" border = "1px">
<form action = "marksListctl.do" method = "post">
   <tr style = "background-color: skyblue">
   <th>Select</th>
   <th>Id</th>
   <th>RollNumber</th>
   <th>Name</th>
   <th>Physics</th>
   <th>Chemestry</th>
   <th>Maths</th>
   <th>Total</th>
   <th>Percantage</th>
   <th>Pass/Fail</th>
   </tr>
   
   <% 
   Iterator it = list.iterator();
    while(it.hasNext()){
    	MarksheetBean bean = (MarksheetBean) it.next();
   %>
   
   <tr style = "background-color: grey">
   <td><input type = "checkbox" name = "ids" value ="<%=bean.getId()%>"></td>
   <td><%=bean.getId() %></td>
   <td><%=bean.getRollno() %></td>
   <td><%=bean.getName() %></td>
   <td><%=bean.getPhysics() %></td>
   <td><%=bean.getChemestry() %></td>
   <td><%=bean.getMaths() %></td>
   <% int total = bean.getPhysics()+bean.getChemestry() +bean.getMaths();
      
      double per =  (total)/3;
    
      if(bean.getPhysics()>33 && bean.getChemestry()>33 && bean.getMaths()>33){
    	  
      }else{
    	  
      }
   %>
   <td><%=total %></td>
   <td><%=per %></td>
   <td> <%
   if(bean.getPhysics()>33 && bean.getChemestry()>33 && bean.getMaths()>33){
   %>pass<%
   }else{
   %>fail<%
   }
   %>
   </td>
   </tr>
   <%} %>
</table>
<table>
  <tr>
    <td><input type = "submit"  name = "operation" value = "delete"></td>
  </tr>
</table>
</form>
</body>
</html>