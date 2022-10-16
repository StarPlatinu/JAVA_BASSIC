<%-- 
    Document   : add
    Created on : Oct 10, 2022, 3:32:13 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add A New Category</h1>
        <h3 style="color: red">${requestScope.error}</h3>
        <form action="add">
            Enter ID: <input type="number" name="id" value="" /><br>
            Enter Name: <input type="text" name="name" value="" /><br>
            Enter Describe: <input type="text" name="describe" value="" /><br>
            <input type="submit" value="SAVE" />
        </form>
    </body>
</html>
