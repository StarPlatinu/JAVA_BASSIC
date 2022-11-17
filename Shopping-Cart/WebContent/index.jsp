<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.DBConnection" %>
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
<%DBConnection.SQLCONNECTION.getConnection();%>
</h1>
<%@include file ="../includes/footer.jsp" %>
</body>
</html>