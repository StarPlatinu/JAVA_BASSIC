/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;

/**
 *
 * @author thanh
 */
@WebServlet(name="LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      String username = request.getParameter("user");
      String password = request.getParameter("pass");
      DAO d = new DAO();
      Admin a = d.check(username, password);
      HttpSession session = request.getSession();
      if(a==null){
          //chua co
          request.setAttribute("error", "username or password invalid!!!");
          request.getRequestDispatcher("login.jsp").forward(request, response);
      }else{
          //Tao session
          session.setAttribute("account", a);
          //role 1 - admin
          if(a.getRole()==1){
              request.getRequestDispatcher("admin.jsp").forward(request, response);
          }else{
               //role 2 - welcome
          request.getRequestDispatcher("wellcome.jsp").forward(request, response);
          }
         
      }
          
          
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
