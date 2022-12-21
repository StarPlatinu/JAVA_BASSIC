<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
<title>Hello, world!</title>
<!-- Google Font -->
</head>
<body>
	<!-- Header -->
	<%@include file="components/navbarTrip.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<!-- Left Content -->
			<div class="col-md-3 left-content bg-light">
			    <%@include file="components/dashboardTrip.jsp"%>
			</div>
			<!-- Right content -->
			<div class="col-md-9 right-content border">
				<div class="container p-5">
					<div class="row">
						<h1>Add Trip</h1>
					</div>
					<hr>
					<div class="row">
						<!-- Form Content -->
						<form action="addTrip" method="post">
							<table class="table1">
								<tr>
									<td><b>Destination<br>
										<span class="text-danger">(*)</span></b></td>
									<td><input name="destination" class="form-control" required="required"
										type="text" placeholder="Enter destination" min="3"
										maxlength="30"></td>
								</tr>
								<tr>
									<td><b>Departure time <span class="text-danger">(*)</span></b></td>
									<td><input name="departureTime" class="form-control" required="required"
										type="text" placeholder="--:-- --" min="3" maxlength="30"></td>
								</tr>
								<tr>
									<td><b>Driver<span class="text-danger">(*)</span></b></td>
									<td><input name="driver" class="form-control" type="text" required="required"
										placeholder="Enter driver" minlength="3" maxlength="30"></td>
								</tr>
								<tr>
									<td><b>Car type <span class="text-danger">(*)</span></b></td>
									<td><input name="carType" class="form-control" type="text" required="required"
										placeholder="Enter car type" minlength="3" maxlength="30"></td>
									</td>
								</tr>
								<tr>
									<td><b>Maximum online ticket <br>number <span
											class="text-danger">(*)</span></b></td>
									<td><input name="maxTicket" class="form-control" required="required"
										type="number" placeholder="Enter price" min="0"></td>
								</tr>

								<tr>
								<td><b>Departure date <span
											class="text-danger">(*)</span></b></td>
									<td><input name="departureDate" class="form-control" type="date"  ></td>
								</tr>

								<tr>
									<td></td>
									<td>
										<div class="btn-submit">
											<button type="reset" class="btn btn-warning text-white">
												<i class="fa fa-undo" aria-hidden="true"></i> Reset
											</button>
											<button type="submit" class="btn btn-success">
												<i class="fa fa-plus" aria-hidden="true"></i> Add
											</button>
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