package fa.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.tripDao;
import fa.training.entity.employee;
import fa.training.entity.trip;


public class AddTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTripController() {
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
	   request.getRequestDispatcher("AddTrip.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String destination = request.getParameter("destination");
		String departureTime = request.getParameter("departureTime");
		String driver = request.getParameter("driver");
		String carType = request.getParameter("carType");
		String maxTicket = request.getParameter("maxTicket");
		String departureDate = request.getParameter("departureDate");
		tripDao tripd = new tripDao();
		trip t = trip.builder()
				.bookedTicketNumber(maxTicket)
				.carType(carType)
				.departureDate(departureDate)
				.departureTime(departureTime)
				.destination(destination)
				.driver(driver)
				.maximumOnlineTicketNumber(maxTicket)
				.build();
		tripd.addTrip(t);
		response.sendRedirect("tripList");
	}

}
