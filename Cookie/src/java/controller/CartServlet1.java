/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author thanh
 */
@WebServlet(name="CartServlet1", urlPatterns={"/cart"})
public class CartServlet1 extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      String id = request.getParameter("id");
      String num = request.getParameter("num");
        Cookie[] arr = request.getCookies();
        String txt = "";
        if(arr!=null){
            for (Cookie cookie : arr) {
                if(cookie.getName().equals("cart")){
                    txt+=cookie.getValue();
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        if((id!=null)&&(num!=null)){
            if(txt.isEmpty()){
                //dat lan dau
                txt=id+":"+num;
            }else{
                txt=txt+"/"+id+":"+num;
            }
        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(2*24*60*60);
        response.addCookie(c);
        response.sendRedirect("cart.jsp");
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
