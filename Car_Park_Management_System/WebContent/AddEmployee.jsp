<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="static/css/myStyle.css">
<!-- Font Awseome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Add Employee</title>
<!-- Google Font -->
</head>

<body>

 <%@include file="components/navbarEmployee.jsp" %>
 
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3 left-content bg-light">
		     <%@include file="components/dashboardEmployee.jsp" %>
			</div>
			<div class="col-md-9 right-content border">
				<div id="view-content" class="content p-5">
					<h2 class="pt-4">Add Employee</h2>
					<hr />
					<div class="row">
						<!-- Form Content -->
						<form action="addEmployee" method="post">
							<table class="table1">
								<tr>
									<td><b>Full name <span class="text-danger">(*)</span></b></td>
									<td><input class="form-control" name="fullname"
										type="text" placeholder="Enter full name" minlength="3"
										maxlength="30" required="required"></td>
								</tr>
								<tr>
									<td><b>Phone number <span class="text-danger">(*)</span></b></td>
									<td><input class="form-control" name="phone" type="text"
										placeholder="Enter phone number" required="required" minlength="3" maxlength="30">
									</td>
								</tr>
								<tr>
									<td><b>Date of birth <span class="text-danger">(*)</span></b></td>
									<td>
										<div class="input-group mb-2">
											<div class="input-group-prepend"></div>
											<input type="date" class="form-control" name="dob"
												id="inlineFormInputGroup" placeholder="">
									</td>
								</tr>
								<tr>
									<td><b>Sex <span class="text-danger">(*)</span></b></td>
									<td><input type="radio" id="male" name="sex" value="M"
										checked> <label for="male">Male</label> <input
										type="radio" id="css" name="sex" value="F"> <label
										for="female">Female</label></td>
								</tr>
								<tr>
									<td><b>Address<span class="text-danger">(*)</span></b></td>
									<td><input class="form-control" name="address" type="text"
										placeholder="Enter address" minlength="3" maxlength="30" required="required"></td>
								</tr>
								<tr>
									<td><b>Email <span class="text-danger"></span></b></td>
									<td><input class="form-control" name="email" type="text"
										placeholder="Enter email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" minlength="3" maxlength="30" required="required"></td>
								</tr>
								<tr>
									<td><b>Account <span class="text-danger">(*)</span></b></td>
									<td><input class="form-control" name="account" type="text"
										placeholder="Enter account" minlength="3" maxlength="30" required="required"></td>
								</tr>
								<tr>
									<td><b>Password <span class="text-danger">(*)</span></b></td>
									<td><input class="form-control" name="password" required="required"
										type="password" placeholder="Enter password" minlength="3"
										maxlength="30"></td>
								</tr>
								<tr>
									<td><b>Department <span class="text-danger">(*)</span></b></td>
									<td><select name="department" class="form-control rounded-right">
											<c:forEach items="${emplist}" var="e">
												<option value="${e.department}">${e.department}</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
								 <td></td>
								 	 <td>
								 	 <div class="btn-submit mr-5">
								<Button class="btn btn-info text-white" type="submit">
								<i class="fa fa-backward" aria-hidden="true"></i> Back
								</Button>
								<Button class="btn btn-warning text-white" type="reset">
									<i class="fa fa-undo" aria-hidden="true"></i> Reset
								</Button>
								<Button class="btn btn-success text-white" type="submit">
									<i class="fa fa-plus" aria-hidden="true"></i> Add
								</Button>
							</div>
							</td> 
								</tr>
							</table>	
						</form>
					</div>
				</div>
			</div>
		</div>
			</div>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
		<script src="static/js/myjs.js"></script>
</body>
</html>
