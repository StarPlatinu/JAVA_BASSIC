/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author thanh
 */
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
        //Lay tu form username va password
        String u =request.getParameter("user");
        String p = request.getParameter("pass");
        
        //Lay tu web.xml: username va pass -> so sanh vs nhau
        String u_init = getServletContext().getInitParameter("user");
        String p_init = getServletContext().getInitParameter("pass");
        if(u.equalsIgnoreCase(u_init)&&p.equalsIgnoreCase(p_init)){
          //nhap dung   
          request.setAttribute("name", u);
          request.getRequestDispatcher("home.jsp").forward(request, response);
        }else{
            //Nhap sai
           String ms = "Ban nhap sai., de nghi nhap lai!";       
            request.setAttribute("error", ms);
            request.getRequestDispatcher("login.jsp").forward(request, response);
         }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
