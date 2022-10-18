<%-- 
    Document   : cart
    Created on : Oct 16, 2022, 10:45:49 AM
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
        <form action="cart">
            Nhap ID: <input type="text" name="id"><br>
            So luong mua: <input type="number" name="num"><br>
            <<input type="submit" name="BO VAO GIO">
        </form>
        <c:set var="cookie" value="${pageContext.request.cookies}"/>
        <jsp:useBean id="list" class="model.Cart" />
        <h1>Danh sach hang mua</h1>
        <table border="1px" width=""30%>
            <tr>
                <th>ID</th>
                <th>So Luong</th>
            </tr>
            <c:forEach items="${list.getCart(cookie.cart.value)}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.quantity}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
