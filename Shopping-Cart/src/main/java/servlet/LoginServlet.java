package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;

import dao.UserDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 2;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
		String email = request.getParameter("login-email");
		String password = request.getParameter("login-password");
		
		UserDao udao = new UserDao();
		User user = udao.userLogin(email, password);	    
		if(user != null) {
			out.print("User login successfull.");
		}else {
			out.print("User login failed.");
		}
		
		}
	}

}
