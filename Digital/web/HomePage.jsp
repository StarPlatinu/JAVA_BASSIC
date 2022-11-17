
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body> 
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <div class="tittle">
                         Day La Bai So 1
                    </div>
                    <div class="image">
                        <img src="images/i1.jpg"/>
                    </div>
                    <div class="text">
                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit, 
                        sed diam nonummy nibh euismod tincidunt ut laoreet dolore 
                        magna aliquam erat volutpat. Ut wisi enim ad minim veniam, 
                        quis nostrud exerci tation ullamcorper suscipit lobortis nisl 
                        ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, 
                        consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt 
                        ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim 
                        veniam, quis nostrud exerci tation ullamcorper suscipit lobortis 
                        nisl ut aliquip ex ea commodo consequat.Lorem ipsum dolor sit amet, 
                        consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt 
                        ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim 
                        veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl 
                        ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, 
                        consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt 
                        ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim 
                        veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl 
                        ut aliquip ex ea commodo consequat.Lorem ipsum dolor sit amet, 
                        consectetuer adipiscing elit, sed diam nonummy nibh euismod 
                        tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi 
                        enim ad minim veniam, quis nostrud exerci tation ullamcorper 
                        suscipit lobortis nisl ut aliquip ex ea commodo consequat. Lorem 
                        ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy 
                        nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. 
                        Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper 
                        suscipit lobortis nisl ut aliquip ex ea commodo consequat.
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                         By Henrry | 2018-10-03
                    </div>
                </div>
                <jsp:include page="Right.jsp"/> 
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
