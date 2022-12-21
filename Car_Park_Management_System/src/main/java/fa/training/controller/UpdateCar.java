package fa.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.carDao;
import fa.training.dao.parkingDao;
import fa.training.entity.car;
import fa.training.entity.employee;

/**
 * Servlet implementation class UpdateCar
 */
@WebServlet("/updateCar")
public class UpdateCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCar() {
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
		String licensePlate = request.getParameter("licensePlate");
		car c = new carDao().getACar(licensePlate);
		request.setAttribute("licensePlate",licensePlate);
		request.setAttribute("caru", c);
		request.getRequestDispatcher("UpdateCar.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String licensePlate = request.getParameter("licensePlate");
		String carColor = request.getParameter("carColor");
		String carType = request.getParameter("carType");
		String company = request.getParameter("company");
		String park = request.getParameter("park");
		parkingDao p = new parkingDao();
		car c = car.builder()
				.licensePlate(licensePlate)
				.carColor(carColor)
				.carType(carType)
				.company(company)
				.park(p.getparkinglotName(park))
				.build();
		new carDao().updateCar(c);
	    response.sendRedirect("carList");
	}

}