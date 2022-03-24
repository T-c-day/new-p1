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
				<li><a href="employeeInfo.jsp">Update Info</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
	
	<!--                         Update form                                                                                       -->
	<div class="container rounded bg-white mt-5 mb-5">
		<div class="row">
			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<img class="rounded-circle mt-5" width="150px"
						src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
				</div>
			</div>
			<div class="col-md-5 border-right">
				<div class="p-3 py-5">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<h4 class="text-right">Update Profile</h4>
					</div>
					<form method="get" action="UpdateEmployeeController" name="updateform">
						<div class="row mt-2">
							<div class="col-md-6">
								<label class="labels"> First Name</label><input type="text"
									class="form-control" placeholder="first name" value=""
									name="fname">
							</div>
							<div class="col-md-6">
								<label class="labels">Last Name</label><input type="text"
									class="form-control" placeholder="last name" value=""
									name="lname">
							</div>

						</div>
						<div class="row mt-3">

							<div class="col-md-12">
								<label class="labels">City</label><input type="text"
									class="form-control" placeholder="enter city" value=""
									name="city">
							</div>
							<div class="col-md-12">
								<label class="labels">State</label><input type="text"
									class="form-control" placeholder="enter state" value=""
									name="state">
							</div>

						</div>
					
					<br />
					<div class="mt-5 text-center">
						<button class="btn btn-primary profile-button" type="submit">Save
							Profile</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>








</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>