/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.training.main;

import com.training.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author thanh
 */
@WebServlet(name="NewServlet", urlPatterns={"/new"})
public class NewServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
     String name = "To Thanh Vu";
     request.setAttribute("name", name);
     Student s = new Student(1, "Le Anh Dung", true, 8);
     request.setAttribute("stu", s);
     String num_raw = request.getParameter("num");
     int num;
        try {
            num = Integer.parseInt(num_raw);
            List<Student> list = new ArrayList<>();
            Random r = new Random();
            int id;
            boolean gender;
            int mark;
            String[] w = {"A","B","C","D","E","G","H","I"};
            for (int i = 0; i < num; i++) {
                id = r.nextInt(99-10+1)+10;
                gender = r.nextBoolean();
                int k = r.nextInt(w.length);
                if(gender){
                    name = "Mr "+w[k];
                }else{
                    name = "Miss "+w[k];
                }
                mark = r.nextInt(11);
                s = new Student(id, name, gender, mark);
                list.add(s);
            }
            request.setAttribute("data", list);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
     request.getRequestDispatcher("h3.jsp").forward(request, response);    
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
