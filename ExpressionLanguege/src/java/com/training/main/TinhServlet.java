/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.training.main;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author thanh
 */
@WebServlet(name = "TinhServlet", urlPatterns = {"/tinh"})
public class TinhServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("tinh.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //LAU TU FORM
        String money_raw = request.getParameter("money");
        String change = request.getParameter("change");
        //lAY TU WEB.XML
        String usds = getServletContext().getInitParameter("usd");
        String yens = getServletContext().getInitParameter("yen");
        double money, usd, yen;
        PrintWriter out = response.getWriter();
        try {
            money = Double.parseDouble(money_raw);
            usd = Double.parseDouble(usds);
            yen = Double.parseDouble(yens);
            double moneyChange;
            if(change.equals("0")){
                moneyChange = money/usd;
            }else{
                moneyChange = money/yen;
            }
           // out.println("Tien: "+moneyChange);
           request.setAttribute("money", moneyChange);
           request.getRequestDispatcher("tinh.jsp").forward(request, response);
           
        } catch (NumberFormatException e) {
           // out.println("Phai nhap so!!!");
           request.setAttribute("error", "Nhap so");
             request.getRequestDispatcher("tinh.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
