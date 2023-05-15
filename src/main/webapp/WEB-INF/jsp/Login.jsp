<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Login</title>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
}

section {
	background-color: #63738a;
}

.container {
	display: flex;
	justify-content: space-around;
}

form {
	background-color: #f2f3f7;
	padding: 8% 9%;
}

form div {
	display: flex;
	justify-content: center;
	align-items: center;
}

input {
	width: 100%;
}

#chk {
	display: block;
}

#check {
	width: auto;
}

button {
	display: flex;
	justify-content: space-between;
	margin-left: 5px !important;
}

#foot {
	color: #fff;
}

#foot a {
	color: #fff;
	text-decoration: underline;
}

.btn {
	display: flex;
	justify-content: space-between;
	width: 100%;
}

.btn a {
	color: #eee;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/">Registration Portal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/Login">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/Register">Register</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/Allstudent">All
						Student</a></li>
			</ul>
		</div>
	</nav>
	<section>
		<article>
			<div class="container p-4">
				<div>i am contact</div>
				<form action="/LoginStudent" method="post">
					<div class="text-center">
						<h1>Student Login</h1>
					</div>
					<c:if test="${not empty errorfail}">
						<div class="alert alert-danger">
							<c:out value="${errorfail}"></c:out>
						</div>
					</c:if>
					<div class="form-group">
						<input type="text" placeholder="Email" name="email"
							value="${student.email}">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" name="password"
							value="${student.password}">
					</div>
					<div id="chk" class="form-group">
						<label class="form-check-label"> <input id="check"
							type="checkbox">Remember Me
						</label>
					</div>
					<div class="form-group text-center">
						<button class="btn btn-success" type="submit">
							<a href="/Register">Register</a>
						</button>
						<button class="btn btn-success" type="submit">
							Login
						</button>
					</div>
					<div class="form-group">
						<p>
							<a href="#">Forgot Password?</a>
						</p>
					</div>
				</form>
			</div>
		</article>
	</section>
</body>
</html>