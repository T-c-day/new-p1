<%@page import="com.training.pms.dao.ReimbursementsDAOImpl"%>
<%@page import="com.training.pms.dao.ReimbursementsDAO"%>
<%@page import="com.training.model.Reimbursements" %>
<%@page import="com.training.pms.dao.UserDAO" %>
<%@page import="com.training.pms.dao.UserDAOImpl" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
				<a class="navbar-brand" href="employeeHome.jsp">Money Portal</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="employeeHome.jsp">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">My Requests <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="employeePending.jsp">Pending</a></li>
						<li><a href="employeeResolved.jsp">Resolved</a></li>
					</ul></li>
				<li><a href="employeeInfo.jsp">My Info</a></li>

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
	String searchname = request.getParameter("searchname");
	%>
	<%
	ReimbursementsDAO dao = new ReimbursementsDAOImpl();
	//List<Reimbursements> rlist = //(List<Reimbursements>)session.getAttribute("resultlist");
	
	List<Reimbursements> rList = dao.getPending1(username);
	//Iterator<Reimbursements> iterator = reimbursements.iterator();
	%>
	<h1 style="text-align:center;border: 2px solid #ec2F4B">My Pending Reimbursements</h1>
	<table border="2" cellspacing="10" cellpadding="10"
		class="table table-striped">
		<tr>
			<th>Date</th>
			<th>Username</th>
			<th>Amount</th>
			<th>Description</th>
			<th>Status</th>
			
		</tr>
		<%
		for(Reimbursements t : rList){
			
		%>
		<tr>
			<td><%=t.getThatday()%></td>
			<td><%=t.getFk_username()%></td>
			<td><%=t.getAmount()%></td>
			<td><%=t.getDescription()%></td>
			<td><%=t.getStatus()%></td>
		</tr>
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