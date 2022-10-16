<%-- 
    Document   : list
    Created on : Oct 10, 2022, 3:16:46 PM
    Author     : thanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function doDelete(id){  
          if(confirm("are you sure to delete category with id = "+id)){
              window.location="check?action=delete&id="+id;
          }      
    }
        </script>        
    </head>
    <body>
    <center>
        <h1>List Of Category</h1> 
        <h3><a href="check?action=add">Add New</a></h3>
        <table border="1" width="40%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Describe</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${requestScope.data}" var="c">
                <c:set var="id" value="${c.id}"/>
                <tr>
                    <td>${id}</td> 
                    <td>${c.name}</td>
                    <td>${c.describe}</td>
                    <td>
                        <a href="check?action=update&id=${id}">Update</a>&nbsp;&nbsp;
                        <a href="#" onclick="doDelete('${id}')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>    
    </center>

</body>
</html>
