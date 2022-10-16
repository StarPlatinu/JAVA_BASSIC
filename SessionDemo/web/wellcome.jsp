<%-- 
    Document   : wellcome
    Created on : Oct 15, 2022, 5:20:37 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="a" value="${sessionScope.account}"/>
        <h1>Day la trang nguoi dung</h1>
        <h1>Hello ${a.username}</h1>
        <h1>Role ${a.role}</h1>
    </body>
</html>
