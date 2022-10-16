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
@WebServlet(name="AddServlet", urlPatterns={"/add"})
public class AddServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
            Category c = cdb.getCategoryById(id);
            if(c==null){
                Category cNew = new Category(id, name, describe);
                cdb.insert(cNew);
                response.sendRedirect("list");
            }else{
                request.setAttribute("error", id+"existed!");
                request.getRequestDispatcher("add.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
