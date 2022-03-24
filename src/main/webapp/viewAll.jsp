<%@page import="com.training.pms.dao.UserDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.training.model.Employee"%>
<%@page import="com.training.pms.dao.UserDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>All Employees</title>
</head>
<body>

<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="managerHome.jsp">Money Portal</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="managerHome.jsp">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Employees <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="managerPending.jsp">Pending</a></li>
						<li><a href="managerResolved.jsp">Resolved</a></li>
						<li><a href="searchUser.jsp">Search Employee</a></li>
						<li><a href="viewAll.jsp">View All Employees</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
<%

String username = (String)session.getAttribute("username"); 
%>
	<%
			UserDAO loginDAO = new UserDAOImpl();
			List<Employee> employee = loginDAO.getUsers();
			Iterator<Employee> iterator = employee.iterator();
	%>
	<h1 class="main" style= "text-align:center;border: 2px solid DodgerBlue">List of all the users</h1>
	<table border="2" class="table table-striped">
		<th>User Id</th>
		<th>User Name</th>
		<th>Password</th>
		<th>Type</th>
		
		<%
		while (iterator.hasNext()) {
			Employee employees = iterator.next();
		%>
		<tr>
			<td><%=employees.getUserID()%></td>
			<td><%=employees.getUsername()%></td>
			<td><%=employees.getPassword()%></td>
			<td><%=employees.getType()%></td>
			<%
			}
			%>
		
	</table>


</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>