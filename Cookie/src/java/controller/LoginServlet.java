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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;

/**
 *
 * @author thanh
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u = request.getParameter("user");
        String p = request.getParameter("pass");
        String r = request.getParameter("rem");
        //tao 3 cookie: username, pass, remember
        Cookie cu = new Cookie("cuser", u);
        Cookie pu = new Cookie("cpass", p);
        Cookie ru = new Cookie("crem", r);
        if (r != null) {
            cu.setMaxAge(60 * 60 * 24 * 7);
            pu.setMaxAge(60 * 60 * 24 * 7);
            ru.setMaxAge(60 * 60 * 24 * 7);
        } else {
            cu.setMaxAge(0);
            pu.setMaxAge(0);
            ru.setMaxAge(0);
        }
        //luu vao browse
        response.addCookie(cu);
        response.addCookie(pu);
        response.addCookie(ru);

        DAO d = new DAO();
        Admin a = d.check(u, p);
      
        if (a == null) {
            //chua co
            request.setAttribute("error", "username or password invalid!!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            //Tao session
               HttpSession session = request.getSession();
            session.setAttribute("account", a);
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
