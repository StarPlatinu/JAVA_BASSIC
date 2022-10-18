<%-- 
    Document   : home
    Created on : Oct 16, 2022, 7:13:19 AM
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
        <h1>Danh Sach Cookie</h1>
        <c:forEach items="${pageContext.request.cookies}" var="c">
            ${c.name}-${c.value}<br>
        </c:forEach>  
    </body>
</html>
