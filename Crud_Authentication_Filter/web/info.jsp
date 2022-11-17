<%-- 
    Document   : info
    Created on : Oct 21, 2022, 9:18:26 AM
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
        <jsp:include page="menu.jsp"/>
        <h1>Profile page</h1>
        <h3>
            Username:${sessionScope.account.username}<br>
            <c:if test="${sessionScope.account.role==1}">
                CHAO MUNG BAN DEN VOI KENH BAN HANG!
            </c:if>
            <c:if test="${sessionScope.account.role==2}">
                CHAO MUNG BAN DEN MUA HANG!
            </c:if>
        </h3>
    </body>
</html>
