<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.DBConnection" %>
<%@ page import="model.User" %>

<%
User auth = (User)request.getSession().getAttribute("auth");
if(auth!=null){
	request.setAttribute("auth", auth);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wellcome To Shopping Cart!</title>
<%@include file ="../includes/head.jsp" %>
</head>
<body>
<%@include file ="../includes/navbar.jsp" %>
<h1>
<%out.print(DBConnection.SQLCONNECTION.getConnection());%>
</h1>
<%@include file ="../includes/footer.jsp" %>
</body>
</html>