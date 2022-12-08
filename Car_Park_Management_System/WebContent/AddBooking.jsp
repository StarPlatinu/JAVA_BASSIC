<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	  <!-- Required meta tags -->
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <link rel="stylesheet" href="static/css/myStyle.css">
      <!-- Font Awseome -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	  <!-- Bootstrap CSS -->
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	  <title>Hello, world!</title>
    <!-- Google Font -->
</head>
<body>
<!-- Header -->
    <div class="container-fluid">
        <nav class="navbar navbar-expand-sm navbar-light bg-light">
            <a class="navbar-brand" href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Booking office</a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-info" href="#">Wellcome username</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-info" href="#"><i class="fa fa-sign-out" aria-hidden="true"></i> Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>


    <div class="container-fluid">
        <div class="row">
            <!-- Left Content -->
            <div class="col-md-3 left-content bg-light">
                <div class="carpark text-info">
                    <a href="#"><i class="fa fa-tachometer" aria-hidden="true"></i> Car park manager </a>
                </div>
                <div class="carmanager">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-car" aria-hidden="true"></i> Car manager&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                            <div class="dropdown-menu p-0 bg-light" aria-labelledby="dropdownId" style="border: none;">
                                <a href="#">&nbsp;&nbsp;<i class="fa fa-list-ul" aria-hidden="true"></i> Car List</a><br>
                                <a href="#">&nbsp;&nbsp;<i class="fa fa-plus" aria-hidden="true"></i> Add Car</a>
                            </div>
                        </li>
                    </ul>  
                   </div>
               <div class="booking">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-bar-chart" aria-hidden="true"></i> Booking office manager&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                        <div class="dropdown-menu p-0 bg-light" aria-labelledby="dropdownId" style="border: none;">
                            <a href="bookingList">&nbsp;&nbsp;<i class="fa fa-list-ul" aria-hidden="true"></i> Booking Office List</a><br>
                            <a href="#">&nbsp;&nbsp;<i class="fa fa-plus" aria-hidden="true"></i> Add Booking Office</a>
                        </div>
                    </li>
                </ul>  
               </div>

              <div class="parking mt-0 pt-0">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Parking lot manager&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                        <div class="dropdown-menu p-0 bg-light" aria-labelledby="dropdownId" style="border: none;">
                            <a href="#">&nbsp;&nbsp;<i class="fa fa-list-ul" aria-hidden="true"></i> Parking lot list</a><br>
                            <a href="#">&nbsp;&nbsp;<i class="fa fa-plus" aria-hidden="true"></i> Add Parking lot</a>
                        </div>
                    </li>
              </div>
            </ul>  
           </div>
          <!-- Right content -->
                <div class="col-md-9 right-content">
                  <div class="container p-5">
                   <div class="row">
                    <h1>Add Booking Office</h1>
                   </div>
                   <hr>
                   <div class="row">
                    <!-- Form Content -->
                    <form action="addBooking" method="post">
                      <table class="table1">                   
                            <tr>
                                <td><b>Booking office name <br><span class="text-danger">(*)</span></b></td>
                                <td><input name="officename" class="form-control" id="fullname" type="text" placeholder="Enter booking office name" minlength="3"
                                        maxlength="30"></td>
                            </tr>
                            <tr>
                                <td><b>Trip <span class="text-danger">(*)</span></b></td>
                                <td><select name="trip" id="inputState" class="form-control">
                                  <c:forEach items="${bookinglist}" var="booking">                           
                              <option>${booking.tripOb.destination }</option>
                             </c:forEach>
                                </select>
                          </td>
                            </tr>
                            <tr>
                              <td><b>Phone number <span class="text-danger">(*)</span></b></td>
                              <td><input name="phone" class="form-control" id="fullname" type="text" placeholder="Enter phone number" minlength="3"
                                      maxlength="30"></td>
                          </tr>
                          <tr>
                            <td><b>Place <span class="text-danger">(*)</span></b></td>
                            <td>
                            <select name="place" id="inputState" class="form-control">
                             <c:forEach items="${bookinglist}" var="booking">                           
                              <option>${booking.officeName}</option>
                             </c:forEach>
                            </select>
                      </td>
                        </tr>
                        <tr >
                          <td><b>Price<span class="text-danger">(*)</span></b></td>
                          <td><input name="price" class="form-control" id="fullname" type="text" placeholder="Enter price" minlength="3"
                                  maxlength="30"></td>
                                  <td><b>(VND)</b></td>
                      </tr> 
                            <tr>
                                <td><b>Contract deadline <span class="text-danger">(*)</span></b></td>
                                <td> 
                                  <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                      <div class="input-group-text">From date</div>
                                    </div>
                                    <input name="start" type="date" class="form-control" id="inlineFormInputGroup" placeholder="Username"></td>
                            </tr>
                            <tr>
                              <td></td>
                              <td>  
                                <div class="input-group mb-2">
                                  <div class="input-group-prepend">
                                    <div class="input-group-text">To date</div>
                                  </div>
                                  <input name="end" type="date" class="form-control" id="inlineFormInputGroup" placeholder="Username"></td>
                          </tr>
                           <tr>
                            <td></td>
                            <td>
                              <div class="btn-submit">
                                <button type="reset" class="btn btn-warning text-white"><i class="fa fa-undo" aria-hidden="true"></i> Reset</button>
                                <button type="submit" class="btn btn-success"><i class="fa fa-plus" aria-hidden="true"></i> Add</button>
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
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="static/js/myjs.js"></script>
</body>
</html>