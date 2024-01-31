
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	 
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
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
					<form action="<%=request.getContextPath()%>/update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="<%=request.getContextPath()%>/insert" method="post">
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
					<input type="hidden" name="patientId" value="<c:out value='${user.patientId}' />" />
				</c:if>
				

				<fieldset class="form-group">
					<label>Patient Name</label> <input type="text"
						value="<c:out value='${user.patientName}' />" class="form-control"
						name="patientName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>age</label> <input type="Number"
						value="<c:out value='${user.age}' />" class="form-control"
						name="age">
				</fieldset>

				<fieldset class="form-group">
					<label>weight</label> <input type="number"
						value="<c:out value='${user.weight}' />" class="form-control"
						name="weight">
				</fieldset>
				
				<fieldset class="form-group">
					<label>height</label> <input type="number"
						value="<c:out value='${user.height}' />" class="form-control"
						name="height">
				</fieldset>
				
				<fieldset class="form-group">
					<label>city</label> <input type="text"
						value="<c:out value='${user.city}' />" class="form-control"
						name="city">
				</fieldset>
				
				<fieldset class="form-group">
					<label>diagnosis</label> <input type="text"
						value="<c:out value='${user.diagnosis}' />" class="form-control"
						name="diagnosis">
				</fieldset>
				
				<fieldset class="form-group">
					<label>doctorId</label> <input type="number"
						value="<c:out value='${user.doctorId}' />" class="form-control"
						name="doctorId">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>