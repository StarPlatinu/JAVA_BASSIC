package fa.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.*;
import fa.training.entity.employee;


public class EmployeeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        employee emp = (employee) req.getSession().getAttribute("account");
	        if (emp == null) {
	            res.sendRedirect("login");
	        } else {
	        	  String accountname = emp.getAccount();
	              request.setAttribute("accountname", accountname);
		employeeDao empdao = new employeeDao();
		String name = "";
		if(request.getParameter("data")!=null) {
			name =	request.getParameter("data");
		}
		List<employee> employeelist = new ArrayList<>();
		employeelist = empdao.getEmployeeByName(name);
		int page, numperpage = 3;
		int size = employeelist.size();
		int num = (size%3==0?(size/3):((size/3)+1));//So trang
		String xpage = request.getParameter("page");
		if(xpage==null) {
			page = 1;
		}else {
			page=Integer.parseInt(xpage);
		}
		int start,end;
		start = (page - 1)*numperpage;
		end = Math.min(page*numperpage, size);
		List<employee> listPage = empdao.getListByPage(employeelist, start, end);
		request.setAttribute("listPage", listPage);
		request.setAttribute("employeelist", employeelist);
		request.setAttribute("page", page);
		request.setAttribute("num", num);
		request.setAttribute("data", name);
		request.getRequestDispatcher("EmployeeList.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		employeeDao empdao = new employeeDao();
		String name = "";
		name =	request.getParameter("data");
		List<employee> employeelist = new ArrayList<>();
		employeelist = empdao.getEmployeeByName(name);
		int page, numperpage = 3;
		int size = employeelist.size();
		int num = (size%3==0?(size/3):((size/3)+1));//So trang
		String xpage = request.getParameter("page");
		if(xpage==null) {
			page = 1;
		}else {
			page=Integer.parseInt(xpage);
		}
		int start,end;
		start = (page - 1)*numperpage;
		end = Math.min(page*numperpage, size);
		List<employee> listPage = empdao.getListByPage(employeelist, start, end);
		request.setAttribute("listPage", listPage);
		request.setAttribute("employeelist", employeelist);
		request.setAttribute("page", page);
		request.setAttribute("num", num);
		request.setAttribute("data", name);
		request.getRequestDispatcher("EmployeeList.jsp").forward(request, response);

	}

}
