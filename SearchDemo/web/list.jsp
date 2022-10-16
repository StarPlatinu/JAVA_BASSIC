<%-- 
    Document   : list
    Created on : Oct 14, 2022, 10:58:49 AM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #wrapper{
                margin-left: 10%;
                margin-right: 10%;
                font-family: sans-serif;
            }
            h3{
                text-align: left;
                color: blue;
            }
            ul{
                list-style: none;
            }
            li{
                width: 25%;
                text-align: center;
                float: left;
                margin: 25px;
                border: 2px solid chocolate;
                border-radius: 20px;
            }
            li img{
                width: 200px;
                height: 200px;
            }
            li a{
                text-decoration: none;
            }
            li:hover{
                background: bisque;
            }
            p{
                margin: 5px;
                color: blue;
                font-size: 12px;
            }
            .old{
                text-decoration: line-through;
                color: red;
            }
            input[type=submit]{
                width: 200px;
                height: 30px;
                background-color: #F90;
                border-radius: 10px;
            }
        </style>
        <script type="text/javascript">
            function change() {
                document.getElementById("f1").submit();
            }
        </script>

    </head>
    <body>

        <div class="wrapper">
          
            <form id="f1" action="list">
                Dong dien thoai:
                <select name="key">
                    <option value="0">All</option>
                    <c:forEach items="${requestScope.categories}" var="c">
                        <option  value="${c.id}">${c.name}</option>
                    </c:forEach>   
                </select><br>
                <input type="text" name="key2" 
                       placeholder="nhap ten, mieu ta">
                <br>
                Tu gia: <input type="number" name="fromprice">
                Den gia: <input type="number" name="toprice"><br>
                 Tu ngay: <input type="date" name="fromdate">
                 Den ngay: <input type="date" name="todate"><br>
                 <input type="submit" value="SEARCH">
            </form>
            <h3>CAC DONG DIEN THOAI</h3>
            <ul>
                <c:forEach items="${requestScope.products}" var="p">              
                    <li>
                        <a href="#">
                            <img src="${p.image}" />
                            <p>${p.name}</p>
                            <p>Gia goc: <span class="old">${(p.price*3)}</span></p>
                            <p>Sale ${p.price}</p>
                        </a> 
                    </li>
                </c:forEach>     
            </ul>
        </div>
    </body>
</html>
