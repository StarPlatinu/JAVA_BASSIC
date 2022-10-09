<%-- 
    Document   : wellcome
    Created on : Oct 9, 2022, 11:43:18 AM
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
        <%
        if(request.getAttribute("name")!=null){
        String name =(String) request.getAttribute("name");
        %>
        <h1>Hello <%= name %>!</h1>
        <%    
            }
        %>
        
    </body>
</html>
