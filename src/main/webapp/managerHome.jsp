<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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

	<div class="main">
		<h1 style= "text-align:center;border: 2px solid DodgerBlue" >Welcome Boss</h1>
		<div class="expcard">
			<div class="expcard_header">
				<h3>From here you can use the navigation bar at the top to do several functions. 
				<ul>
				<li>View All Pending Reimbursements</li>
				<li>View All Resolved Reimbursements</li>
				<li>Search For Employee Details</li>
				<li>View All Employees</li>
				</ul>
				</h3>
			</div>

		</div>

	</div>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>