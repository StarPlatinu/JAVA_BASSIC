<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	  <!-- Required meta tags -->
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <link rel="stylesheet" href="static/css/myStyle.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	  <!-- Bootstrap CSS -->
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	  <title>Hello, world!</title>
    <!-- Google Font -->
</head>
<body>

<%@include file="components/navbarCar.jsp" %>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3 left-content bg-light">
            <%@include file="components/dashboardServices.jsp" %>
            </div>

                <div class="col-md-9 right-content border">
                  <div class="container p-5">
                    <div class="row">
                        <h1>Car List</h1>                
                    </div>
                    <hr>
			<div class="row  p-2">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<form action="carList" method="post">
								<div class="input-group mb-2 mr-sm-2">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-search" aria-hidden="true"></i>
										</div>
									</div>
									<input name="data" type="search"
										class="form-control rounded-left-0" placeholder="Search"
										aria-label="Search" aria-describedby="search-addon" />
								</div>
						</div>
						<div class="col-md-3">
							<div class="input-group mb-2 mr-sm-2">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fa fa-filter" aria-hidden="true"></i>&nbsp Filter By
									</div>
								</div>
								<select class="select rounded-right border-info">
									<c:forEach items="${parkinglist}" var="p">
										<option value="">${p.parkPlace}</option>
									</c:forEach>
								</select>

							</div>
						</div>
						<div class="col-md-1">
							<button class="btn btn-primary" type="submit">Search</button>
						</div>
						</form>
					</div>
                  <div class="row">
                    <table class="table table-bordered">
                        <thead class="table-active">
                        
                            <tr>
                                <th scope="col">License plate</th>
                                <th scope="col">Car type</th>
                                <th scope="col">Car color</th>
                                <th scope="col">Company</th>
                                <th scope="col">Parking lot</th>
                                <th scope="col">Action</th>
                            
                              </tr>
                        </thead>
                        <tbody>
                         <c:forEach items="${listPerPage}" var="car">
                              <tr>
                               
                                <td>${car.licensePlate}</td>
                                <td>${car.carColor}</td>
                                <td>${car.carType}</td>
                                <td>${car.company}</td>
                                <td>${car.park.parkName}</td>
                                <td>   
                                <a href="updateCar?licensePlate=${car.licensePlate}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</a>&nbsp
                                <a href="deleteCar?licensePlate=${car.licensePlate}"><i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
                                </td>
                              </tr>
                            
                             </c:forEach>
                        </tbody>
                      </table>
                  </div>

                     <c:set var="page" value="${requestScope.page}" />
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
							</a></li>
							<c:forEach begin="${1}" end="${requestScope.num}" var="i">
								
								<li class="page-item "><a class="page-link"
									href="carList?data=${data}&&page=${i}">${i}</a></li>
							</c:forEach>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
									class="sr-only">Next</span>
							</a></li>
						</ul>
					</nav>
                </div>
        </div>
    </div>
    </div>
    </body>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="static/js/myjs.js"></script>
</body>
</html>
