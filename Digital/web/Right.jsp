<%-- 
    Document   : Right
    Created on : Apr 11, 2019, 8:42:53 PM
    Author     : Hoan toan hanh phuc 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Right</title>
            <link href="css/right.css" rel="stylesheet" type="text/css" />
        </head>
        <body>
            <div class="right">
                <div class="newst">
                    <div class="titleNews">
                        <span>Digital News</span>
                    </div>
                    <div class="contentNews">
                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit, 
                        sed diam nonummy nibh euismod tincidunt ut laoreet dolore 
                        magna aliquam erat volutpat. Ut wisi enim ad minim veniam, 
                        quis nostrud exerci tation ullamcorper suscipit lobortis 
                        nisl ut aliquip ex ea commodo consequat. Lorem ipsum dolor 
                        sit amet, consectetuer adipiscing elit, sed diam nonummy nibh 
                        euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
                        Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper 
                        suscipit lobortis nisl ut aliquip ex ea commodo consequat.Lorem 
                        ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy 
                        nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
                        Xin chao thay tuan
                    </div>
                </div>
                <div class="newst">
                    <div class="titleNews">
                        Search
                    </div>
                    <form action="SearchResultPage.jsp" method="post">
                        <input class="searchBox" type="text" name="txtSearch" size="15"  required>
                        <input class="searchButton" type="submit" name="btnGo" value="Go">
                    </form>                        
                </div>
                <div class="newst">
                    <div class="titleNews">
                        <span>Last Articles</span><br>
                    </div>
                <c:forEach begin="1" end="5">
                    <div class="lastArticles">
                        <a href="Detail.jsp">Day la bai so 1</a>
                    </div>
                </c:forEach>
            </div>
        </div>    
    </body>
</html>
