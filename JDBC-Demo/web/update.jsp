<%-- 
    Document   : update
    Created on : Oct 10, 2022, 9:37:45 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Update A New Category</h1>  
       <c:set var="c"  value="${requestScope.category}"/>
       <form action="update" method="post">
            Enter ID: <input type="number" readonly name="id" value="${c.id}"/><br>
            Enter Name: <input type="text" name="name" value="${c.name}" /><br>
            Enter Describe: <input type="text" name="describe" value="${c.describe}" /><br>
            <input type="submit" value="Update" />
        </form>
    </body>
</html>
