<%-- 
    Document   : Expression
    Created on : Oct 10, 2022, 6:10:40 AM
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
        <h1>Vi du cho java bean</h1>
        <form>
            Nhap so 1: <input type="number" name="n1" value="${param.n1}" /><br>
            Nhap so 2: <input type="number" name="n2" value="${param.n2}" /><br>
            Nhap so 3: <input type="number" name="n3" value="${param.n3}" /><br>
            <input type="submit" value="Tinh Toan">
        </form>
        <h2>Tong: ${(param.n1+param.n2+param.n3)}</h2>
        <h2>Average: ${(param.n1+param.n2+param.n3)/3}</h2>
        <h2>Dien tich duong tron: ${param.n1*param.n1*Math.PI}</h2>
        <h4>Data lay tu server: Hello ${requestScope.name}</h4> 
        <h2 style="color: chocolate">Thong Tin: ${requestScope.stu}</h2>
    </body>
</html>
