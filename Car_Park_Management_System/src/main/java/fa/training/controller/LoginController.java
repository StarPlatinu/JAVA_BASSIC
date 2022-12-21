package fa.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.employeeDao;
import fa.training.entity.employee;
import fa.training.util.Validation;
import javax.servlet.http.Cookie;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		employee emp = new employeeDao().getAccount(account, password);
		if(emp != null) {
			request.getSession().setAttribute("account", emp);
			 Cookie uCookie = new Cookie("account", account);
             uCookie.setMaxAge(2 * 24 * 3600);
             Cookie pCookie = new Cookie("password", password);
             pCookie.setMaxAge(2 * 24 * 3600);
             response.addCookie(uCookie);
             response.addCookie(pCookie);
			if(emp.getRole() == 1) {
			response.sendRedirect("bookingList");
			}else if (emp.getRole() == 2){
				response.sendRedirect("employeeList");	
			}
		}else {	
			String error = "Login false !!!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
