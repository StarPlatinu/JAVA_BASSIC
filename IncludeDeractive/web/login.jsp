<%-- 
    Document   : login
    Created on : Oct 9, 2022, 11:27:16 AM
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
        <h1>Login Form</h1>
        <%
        if(request.getAttribute("error")!=null){
        String er = (String)request.getAttribute("error");
        %>
        <h2 style="color:red"><%= er%></h2>
        <%
            }
        %>
        <form action="login" method="post">
            Enter Username: <input type="text" name="user"><br>
            Enter Username: <input type="password" name="pass"><br>
            <input type="submit" name="LOGIN">
        </form>
            
    </body>
</html>
