<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Content"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Profile</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
	integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ"
	crossorigin="anonymous" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet" href="/recources/css/profile.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>

<style type="text/css">
      .pagination a:hover{
      background-color: green;
      }
</style>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<main>
		<div class="row w-100">
			<!-- Left menu  -->
			<div class="col-sm-3 bg-light p-0 border">
				<div class="bg-light border">
					<div class="row mt-3 mb-3 justify-content-center">
						<div class="col-sm-7 p-0">
							<input class="border rounded p-1 pr-5 w-100" type="text"
								name="search" placeholder="Search..." />
						</div>
						<div id="search-button"
							class="col-sm-1 bg-white border-top-0 rounded p-0">
							<i class="fa fa-search p-2"></i>
						</div>
					</div>
				</div>

				<div id="view-content-btn" class="border p-2 pl-4 text-info">
					<i class="far fa-list-alt"></i><span><a href="viewcontent">
							View contents</a></span>
				</div>

				<div id="form-content-btn" class="border p-2 pl-4 text-info">
					<i class="far fa-edit"></i><span> <a href="formcontent">
							Form-content</a></span>
				</div>
			</div>

			<!-- Right content  -->

			<!-- Edit profile  -->
			<div class="col-sm-9">
				<div id="view-content">
					<h2 class="pt-4">View Content</h2>
					<hr class="border" />
					<div class="profile-form border rounded">
						<div id="profile-header" class="bg-light border p-2">
							<span class="">View Content List</span>
						</div>
						<div id="profile-input" class="bg-white border p-3">
							<table id="table-data" class="table table-bordered">
								<thead>
									<tr>
										<th>Title</th>
										<th>Brief</th>
										<th>Created Date</th>
										<th>Update</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<!--                    
                   <c:forEach items="${requetscope.list}" var="el">
                    <tr>
                        <td>${el.getTitle()}</td>
                        <td>${el.getBrief()}</td>
                         <td>${el.getContent()}</td>
                        <td>${el.getCreatedDate()}</td>                      
                    </tr>
                   </c:forEach>     

									<c:forEach items="${list}" var="el" varStatus="loop">
										<tr>
											<td><c:out value=" ${el.getTitle()}" /></td>
											<td><c:out value=" ${el.getBrief()}" /></td>
											<td><c:out value="${el.getContent()}" /></td>
											<td><c:out value=" ${el.getCreatedDate()}" /></td>
										</tr>
									</c:forEach>
-->

									<%
									List<Content> list = new ArrayList<>();
									list = (List<Content>) request.getAttribute("listPerPage");
									for (Content el : list) {
									%>
									<tr>
										<td><%=el.getTitle()%></td>
										<td><%=el.getBrief()%></td>
										<td><%=el.getCreatedDate()%></td>
										<td><a href="update?tilem=<%=el.getTitle()%>"><i class="fas fa-cut"></i></a></td>
										<td><a href="delete?tile=<%=el.getTitle()%>"><i class="fas fa-eraser"></i></a></td>
										<td></td>
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
						</div>
					</div>
					<br>
					<c:set var="page" value="${requestScope.page }" />
					<c:set var="data" value="${requestScope.data }" />
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
							</a></li>
							<c:forEach begin="${1}" end="${requestScope.num}" var="i">
								<!-- ${i==page?"active":""} -->
								<li class="page-item"><a class="page-link"
									href="search?data=${data}&&page=${i}">${i}</a></li>
							</c:forEach>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
									class="sr-only">Next</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>

			<!-- Add content -->
			<!-- Button  -->
			<!-- View content -->
			<!-- End Right Content -->
		</div>
	</main>
	<!-- Optional JavaScript -->
	<!-- <script src="../resources/js/add-content.js"></script> -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
		// <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
	</script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>