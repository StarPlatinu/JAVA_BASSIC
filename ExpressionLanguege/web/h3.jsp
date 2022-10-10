<%-- 
    Document   : h3
    Created on : Oct 10, 2022, 8:07:55 AM
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
        <h1>Vi du cho JSTL</h1>
        <c:set var="s" value="${requestScope.stu}" />
        <h2>Hello ${s.name}</h2>
        <h2>${s.gender?'Male':'Female'}</h2>
        <c:if test="${s.mark>=5}">
            <h3>Pass</h3> 
        </c:if>
        <c:if test="${s.mark<5}">
            <h3>Fail</h3> 
        </c:if>
        <h1>Danh sach sinh vien</h1>
        <table border="1" width="40%">     
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>GENDER</th>
                <th>RANK</th>
                <th>MARK</th>
            </tr>             

            <c:forEach items="${requestScope.data}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.name}</td>
                    <td>${i.gender?'Male':'Female'}</td>
                    <td>
                        <h3>
                            <c:choose>
                                <c:when test="${i.mark<5}">
                                    Weak
                                </c:when>
                                <c:when test="${i.mark>=5&& i.mark < 8}">
                                    Average
                                </c:when>
                                <c:when test="${i.mark>=8}">
                                    Excellent
                                </c:when>
                            </c:choose>
                        </h3>
                    </td>
                    <td>${i.mark}</td>
                </tr> 
            </c:forEach>

        </table>

    </body>
</html>
