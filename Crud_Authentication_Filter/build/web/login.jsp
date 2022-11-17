<%-- 
    Document   : login
    Created on : Oct 15, 2022, 4:58:51 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <h3 style="color: red">${requestScope.ms}</h3>
        <form action="login" method="post">
            Enter username: <input type="text" name="user"/><br>
            Enter password: <input type="password" name="pass"/><br>
            <input type="submit" value="LOGIN"/>
        </form>
    </body>
</html>
