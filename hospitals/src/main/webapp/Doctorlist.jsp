<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Hindu Hospital</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green;">
			<div>
				<a href="https://hindumissionhospital.in/" class="navbar-brand"> Hindu
					Hospital </a>
			</div>

			<ul class="navbar-nav">
				<li><h6 class="nav-link" style="position: absolute; margin-top: -20px;"><c:out value="${email}" /> </h6></li>
			</ul>
			
			<div   style="position: absolute; margin-left: 35cm;">
			<ul class="navbar-nav">
				<li><a class="nav-link" href="https://hindumissionhospital.in/about-us/" class="navbar-brand">About us </a></li>
			</ul>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Doctor</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">New Appointment</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr style="background-color: lightgray">
						<th>ID</th>
						<th>Name</th>
						<th>Type</th>
						<th>Available Time</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="doctor" items="${listDoctor}">

						<tr>
							<td><c:out value="${doctor.id}" /></td>
							<td><c:out value="${doctor.name}" /></td>
							<td><c:out value="${doctor.type}" /></td>
							<td><c:out value="${doctor.time}" /></td>
							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>