<%-- 
    Document   : tinh
    Created on : Oct 10, 2022, 10:03:26 AM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h3 style="color: blue">${requestScope.error}</h3>
     <h1>CHANGE MONEY</h1>
     <form action="tinh" method="post" >
            Enter VND: <input type="text" name="money" value="" /><br>
            <input type="radio" name="change" checked value="0" />To USD
            <input type="radio" name="change" value="1" />To YEN<br>
            <input type="submit" value="change" />
        </form>
     <h2 style="color: blue">Tien:${requestScope.money} </h2>
</html>
