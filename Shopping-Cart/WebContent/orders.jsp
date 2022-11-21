<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="model.User" %>
    <%
User auth = (User)request.getSession().getAttribute("auth");
if(auth!=null){	
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders Page</title>
<%@include file ="../includes/head.jsp" %>
</head>
<body>
<%@include file ="../includes/navbar.jsp" %>


<%@include file ="../includes/footer.jsp" %>
</body>
</html>