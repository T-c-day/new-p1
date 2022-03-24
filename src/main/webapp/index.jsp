<!DOCTYPE html>
<html>
<head>
<title>ERS</title>
<link type="text/css" rel="stylesheet" href="styles.css">
<script type="text/javascript">
function validate() {
	var uname = document.getElementById("username").value;
	var pwd = document.getElementById("password").value;
	var errUn = document.getElementById("errUsername");
	var errPwd = document.getElementById("errPassword");
	errUn.innerHTML = "";
	errPwd.innerText = "";
	if(uname.length == 0) {
		errUn.innerHTML = "<font color=red>Please enter username</font>";
		return false;
	} else if(pwd.length < 6 || pwd.length > 12) {
		errPwd.innerHTML = "<font color=red>Please enter password between 6 and 12</font>";
		return false;
	}
}
</script>
</head>
<body>
	<section class="login" id="login">
		<div class="heading">
			<h1 class="project">Employee Reimbursement System</h1>
		</div>
		<div class="form">
			<form class="form-style" action="LoginController"
				onsubmit="return validate()" method="post">

				<input type="text" id="username" name="username" placeholder="Username"
					class="username" required><span id="errUsername"></span> <br />

				<input type="password" class="password" name="password" id="password"
					placeholder="password"><span id="errPassword"></span>

				<br /> <input type="submit" value="Login" class="login"
					id="login"> <a href="signup.html" class="signup">Sign Up</a>

			</form>

		</div>
	</section>
</body>
</html>