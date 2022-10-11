/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author thanh
 */
@WebServlet(name = "UpdateServler", urlPatterns = {"/update"})
public class UpdateServler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServler</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServler at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        int id;
        CategoryDAO cdb = new CategoryDAO();
        try {
            id = Integer.parseInt(id_raw);
            Category c = cdb.getCategoryById(id);
            request.setAttribute("category", c);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (NumberFormatException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //Lay du lieu tu form
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        int id;
        CategoryDAO cdb = new CategoryDAO();

        try {
            id = Integer.parseInt(id_raw);
            Category cNew = new Category(id, name, describe);
            cdb.update(cNew);
            response.sendRedirect("list");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
