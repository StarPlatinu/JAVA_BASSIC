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
import jakarta.servlet.http.HttpSession;
import model.Category;

/**
 *
 * @author thanh
 */
@WebServlet(name="CheckServlet", urlPatterns={"/check"})
public class CheckServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      HttpSession session = request.getSession();
        CategoryDAO cdb = new CategoryDAO();
      if(session.getAttribute("account")==null){
          request.getRequestDispatcher("login.jsp").forward(request, response);
      }else{
        String action = request.getParameter("action");
        if(action.equals("add")){
            request.getRequestDispatcher("add.jsp").forward(request, response);
        }
        if(action.equals("delete")){
            String id_raw = request.getParameter("id");
            int id;
            try {
                id = Integer.parseInt(id_raw);
                cdb.delete(id);
                request.getRequestDispatcher("list").forward(request, response);
            } catch (NumberFormatException e) {
            }
        }
        if(action.equals("update")){
          String id_raw = request.getParameter("id");
            int id;
            try {
                id = Integer.parseInt(id_raw);
               Category c = cdb.getCategoryById(id);
               request.setAttribute("category", c);
               request.getRequestDispatcher("update.jsp").forward(request, response);
            } catch (NumberFormatException e) {
            }
        }
        
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
