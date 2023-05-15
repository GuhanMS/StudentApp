<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
</head>
<style>
.left {
	height: 250px;
	background-color: blue;
	color: #eee;
	margin-right: 20px !important;
}

.h3 {
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.editDelete {
	display: flex;
	justify-content: space-between;
}
</style>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/">Registration Portal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/Login">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/Register">Register</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/Allstudent">All
						Students</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Enter Student ID" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>

	<section class="container">
<!-- 		<article class="card"> -->
			<div class="card-body">
				<div class="row">
					<div class="col-md-3 left">
						<h3 class="h3 font-weight-bold text-center">${studentView.firstname}
							${studentView.lastname}</h3>
					</div>
					<div class="col-md-3 card" style="color: black;">

						<h5 class="card-title">${studentView.id}</h5>
						<h5 class="card-title">${studentView.firstname}</h5>
						<h5 class="card-title">${studentView.lastname}</h5>
						<h5 class="card-title">${studentView.email}</h5>
						<h5 class="card-title">${studentView.password}</h5>
						<div class="editDelete">
							<h5>
								<a id="details" class="card-title text-left"
									href="/EditStudent?id=${studentView.id}"><i
									class="fa fa-edit"></i></a>
							</h5>
							<h5 class="card-title text-right">
								<a href="/DeleteStudent?id=${studentView.id}"><i
									class="fa fa-trash"></i></a>
							</h5>
						</div>
					</div>
				</div>
			</div>
<!-- 		</article> -->
	</section>

</body>
</html>