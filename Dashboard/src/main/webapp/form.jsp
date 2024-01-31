<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> User
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>PatientId</th>
						<th>PatientName</th>
						<th>age</th>
						<th>weight</th>
						<th>height</th>
						<th>city</th>
						<th>diagnosis</th>
						<th>doctorId</th>
						
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.patientId}" /></td>
							<td><c:out value="${user.patientName}" /></td>
							<td><c:out value="${user.age}" /></td>
							<td><c:out value="${user.weight}" /></td>
							<td><c:out value="${user.height}" /></td>
							<td><c:out value="${user.city}" /></td>
							<td><c:out value="${user.diagnosis}" /></td>
							<td><c:if test="${user != null}"><c:out value="${user.doctorId.toString()}" /></c:if></td>
						
							<td><a href="edits?patientId=${user.patientId}" >Edit</a>


								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=${user.patientId}">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>