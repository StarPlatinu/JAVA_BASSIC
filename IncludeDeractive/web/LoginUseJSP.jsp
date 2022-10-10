<%-- 
    Document   : LoginUseJSP
    Created on : Oct 9, 2022, 1:29:14 PM
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
        <h1>Login Form</h1>
        <%
          String u_init = getServletContext().getInitParameter("user");
        String p_init = getServletContext().getInitParameter("pass");
        if(request.getParameter("user")!=null&&request.getParameter("pass")!=null){
           String u =request.getParameter("user");
        String p = request.getParameter("pass");
         if(u.equalsIgnoreCase(u_init)&&p.equalsIgnoreCase(p_init)){      
          request.setAttribute("name", u);
          request.getRequestDispatcher("LoginUseJSP.jsp").forward(request, response);
          %>
          <jsp:forward page="wellcome.jsp">
              <jsp:param name="name" value="<%=u%>"/>
          </jsp:forward>
          <%
        }else{
         //nguoi dung nhap sai
         String er = "Ban nhap sai, de nghi nhap lai.";
         %>
         <h3 style="color: red"><%= er %></h3>
         <%
        }
            }
        %>
        <form>
            Enter Username: <input type="text" name="user"><br>
            Enter Username: <input type="password" name="pass"><br>
            <input type="submit" name="LOGIN">
        </form>
            
    </body>
</html>
