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
			style="background-color: green">
			<div>
				<h1 class="navbar-brand"> Appointments </h1>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>
				<fieldset class="form-group">
					<label>User Mobile</label> <input type="tel" maxlength="10"
						value="<c:out value='${user.mobile}' />" class="form-control"
						name="mobile" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>User Type</label> <select
						value="<c:out value='${user.type}' />" class="form-control"
						name="type" required="required">
    <option value="Generalist">Generalist</option>
    <option value="Ortho">Ortho</option>
    <option value="Dentist">Dentist</option>
    <option value="Heart Specialist">Heart Specialist</option>
    <option value="Child Specialist">Child Specialist</option>
  </select>
				</fieldset>


				<fieldset class="form-group">
					<label>User Time</label> <input type="datetime-local" 
						value="<c:out value='${user.time}' />" class="form-control"
						name="time">
   
				</fieldset>


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

<script>
  var today = new Date().toISOString().slice(0, 16);
  document.getElementsByName("time")[0].min = today;
</script>
</html>