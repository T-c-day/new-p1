<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
					data-toggle="dropdown" href="#">My Requests <span class="caret"></span></a>
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

	<div class="main">
		<h1 style="text-align:center;border: 2px solid #ec2F4B">Employee Home Page</h1>
		<div class="expcard">
			<div class="expcard_header">
			
			
				<form class="main_form" style="width: 500px; margin: 50px" action="submitrb" method="get">
				<header>
					<h4>Submit New Expense Report</h4>
				</header>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="date">Date</label> <input type="date" id="date" name="date">
							</div>
						</div>
						<div class="col">
							<label for="username">Username</label> <input type="text"
								name="username" id="username" class="form-control" required>
						</div>
						<div class="col">
						<br/>
						<label for="description">Description</label>
						<select name="description" id="description" class="form-control" required>
						<option >Select One</option>
						<option value="travel">Travel</option>
						<option value= "lodging">Lodging</option>
						<option value="Meals">Meals</option>
						</select>
					
						<small class="form-text text-muted">Please select how the funds were used</small>
						<br/>
						<label for="amount">Amount</label>
						<input type="text" name="amount" class="form-control" required>
						<small class="form-text text-muted">Please round to the nearest whole dollar</small>
						</div>
						<input type="submit" value="Create">
					</div>
				</form>
			</div>
		</div>

	</div>

	</div>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>