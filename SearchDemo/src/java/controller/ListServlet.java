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
import java.sql.Date;
import java.util.List;
import models.Category;
import models.Product;

/**
 *
 * @author thanh
 */
@WebServlet(name = "ListServlet", urlPatterns = {"/list"})
public class ListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO d = new DAO();
        List<Category> list = d.getAll();
        request.setAttribute("categories", list);
        String cid_raw = request.getParameter("key");
        String key = request.getParameter("key2");
        String from_raw = request.getParameter("fromdate");
        String to_raw = request.getParameter("todate");
        String fromprice_raw = request.getParameter("fromprice");
        String toprice_raw = request.getParameter("toprice");
        Double price1, price2;
        Date from, to;

        int cid;
        try {
            cid = (cid_raw == null) ? 0 : Integer.parseInt(cid_raw);
            price1 = ((fromprice_raw == null) || (fromprice_raw.equals(""))) ? null : Double.parseDouble(fromprice_raw);
            price2 = ((toprice_raw == null) || (toprice_raw.equals(""))) ? null : Double.parseDouble(toprice_raw);
            from = ((from_raw == null) || (from_raw.equals(""))) ? null : Date.valueOf(from_raw);
            to = ((to_raw == null) || (to_raw.equals(""))) ? null : Date.valueOf(to_raw);
            List<Product> products = d.search(key, from, to, price1, price2, cid);
            request.setAttribute("products", products);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (NumberFormatException e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
