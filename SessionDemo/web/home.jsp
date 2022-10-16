<%-- 
    Document   : home
    Created on : Oct 15, 2022, 9:09:09 AM
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
        <h1>Day la request: ${requestScope.name}</h1>
        <h1>Day la session: ${sessionScope.fu}</h1>
    </body>
</html>
