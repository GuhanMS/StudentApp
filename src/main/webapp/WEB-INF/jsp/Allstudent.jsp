<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
</head>
<style>
#details {
	color: #eee;
}
</style>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/">Registration Portal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">

			<!-- 		<ul class="navbar-nav ml-auto">  this will move the content on the right-->
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
				<li class="nav-item"><a class="nav-link" href="/pdf"><i
						class="fas fa-file-pdf"></i></a></li>
				<li class="nav-item"><a class="nav-link" href="/excel"><i
						class="fas fa-file-excel"></i></a></li>
			</ul>
		</div>
	</nav>
	<div class="container text-center">
		<h3>All Student</h3>
		<hr>
		<c:if test="${not empty errorSuccess}">
			<div class="alert alert-success">
				<c:out value="${errorSuccess}"></c:out>
			</div>
		</c:if>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Password</th>
						<!-- <th>View</th> -->
						<th>View</th>
						<!-- <th>Delete</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${student}" var="userList">
						<tr>
							<td>${userList.id}</td>
							<td>${userList.firstname}</td>
							<td>${userList.lastname}</td>
							<td>${userList.email}</td>
							<td>${userList.password}</td>
							<%-- <td><button class="btn btn-success">
									<a id="details" href="/EditStudent?id=${userList.id}">Edit</a>
								</button></td> --%>
							<td><button class="btn btn-primary">
									<a id="details" href="/Student?id=${userList.id}">More
										Details</a>
								</button></td>
							<%-- <td><a href="/DeleteStudent?id=${userList.id}">Delete</a></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>