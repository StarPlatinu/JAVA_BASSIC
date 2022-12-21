package fa.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.employeeDao;
import fa.training.entity.employee;
import fa.training.util.Validation;

public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        employee emp = (employee) req.getSession().getAttribute("account");
	        if (emp == null) {
	            res.sendRedirect("login");
	        } else {
	        	  String accountname = emp.getAccount();
	              request.setAttribute("accountname", accountname);
		employeeDao emp1 = new employeeDao();
		List<employee> e = new ArrayList<>();
		e = emp1.getAll();	
		request.setAttribute("emplist", e);
		request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String account = request.getParameter("account");
		String password = new Validation().encodedPassword(request.getParameter("password"));
		String department = request.getParameter("department");
		
		employee emp = employee.builder()
				.employeeId(0)
				.account(account)
				.department(department)
				.employeeAddress(address)
				.employeeBirthdate(dob)
				.employeeEmail(email)
				.employeeName(name)
				.employeePhone(phone)
				.password(password)
				.sex(sex)
				.role(1)
				.build();
		employeeDao db = new employeeDao();
		db.addEmployee(emp);
		response.sendRedirect("employeeList");

	}

}
