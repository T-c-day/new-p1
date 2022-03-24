<%@page import="io.opentelemetry.exporter.logging.SystemOutLogExporter"%>
<%@page import="com.training.pms.dao.ReimbursementsDAOImpl"%>
<%@page import="com.training.pms.dao.ReimbursementsDAO"%>
<%@page import="com.training.model.Reimbursements" %>
<%@page import="com.training.pms.dao.UserDAO" %>
<%@page import="com.training.pms.dao.UserDAOImpl" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Pending Requests</title>
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
	<!--                       Table information                           -->
	<%
	String username = (String) session.getAttribute("username");

	%>
	<%
	ReimbursementsDAO dao = new ReimbursementsDAOImpl();
	List<Reimbursements> rList = dao.getemployeePending();
	%>
	<h1 style= "text-align:center;border: 2px solid DodgerBlue">Pending Reimbursements</h1>
	<table border="2" cellspacing="10" cellpadding="10"
		class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Amount</th>
			<th>Description</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
		<%
		for(Reimbursements t : rList){
			System.out.println(t.getReimId());
			%>
		<tr>
			<td><%=t.getReimId()%></td>
			<td><%=t.getFk_username()%></td>
			<td><%=t.getAmount()%></td>
			<td><%=t.getDescription()%></td>
			<td><%=t.getStatus()%></td>
			<td>
			<input type="radio" value="approve" id="radio<%=t.getReimId()%>" name="radio<%=t.getReimId()%>" >
			<label for="radio<%=t.getReimId()%>">Approve</label>
			<input type="radio" value="deny" id="radio<%=t.getReimId()%>" name="radio<%=t.getReimId()%>">
			<label for="radio<%=t.getReimId()%>">Deny</label>
			
			</td>
		</tr>
		
		<%
		}	
		%>
		
		<tr>
		<td>
		<form action= "ManageReimbursementController" method="get" >
			<button type="submit">Submit</button>
		</form>
		</td>
		</tr>
	</table>
	
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>