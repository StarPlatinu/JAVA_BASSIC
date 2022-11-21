<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.User"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
<%@include file="../includes/head.jsp"%>
</head>
<body>
	<%@include file="../includes/navbar.jsp"%>

	<div class="container">

		<div class="card-header my-3">All Products</div>
		<div class="row">
			<div class="col-md-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="https://picsum.photos/200/300" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<h6 class="price">Price: $462</h6>
						<h6 class="category">Category: Some category</h6>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
					     <div class="mt-3 d-flex justify-content-between">
					     <a href="#" class="btn btn-primary">Add to Cart</a>
					     	     <a href="#" class="btn btn-primary">Buy Now</a>
					     </div>			
					</div>
				</div>
			</div>
		</div>
	</div>


	<%@include file="../includes/footer.jsp"%>
</body>
</html>