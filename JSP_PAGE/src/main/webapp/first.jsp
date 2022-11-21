<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="index.html" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The First JSP</title>
</head>
<body>
<%!String stringHello = "Hello, Wellcome to the First JSP!";%>
<%=stringHello %>
Today is: <%=new Date() %>

<jsp:forward page="Welcome.jsp"></jsp:forward>
</body>
</html>