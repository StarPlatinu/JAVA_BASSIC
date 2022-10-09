<%-- 
    Document   : home
    Created on : Oct 9, 2022, 10:48:38 AM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <link rel="stylesheet" href="myStyle.css">
    </head>
    <body>
        <div class="menu_tab">
            <%@include file="menu.jsp"%>    
        </div>  
        <div class="container">
            <%@include file="content.jsp"  %>
        </div>
        <div class="footer">
            <%@include file="footer.jsp"%>    
        </div>
    </body>
</html>
