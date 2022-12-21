package fa.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.ticketDao;
import fa.training.dao.tripDao;
import fa.training.entity.*;

public class AddTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTicketController() {
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
		tripDao tripd = new tripDao();
		ticketDao tickd = new ticketDao();
		List<ticket> listTicket = tickd.getAll();
		List<trip> listTrip = tripd.getAll();
		request.setAttribute("listTrip", listTrip);
		request.setAttribute("listTicket", listTicket);
	    request.getRequestDispatcher("AddTicket.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customer = request.getParameter("customer");
		String time = request.getParameter("time");
		String trip = request.getParameter("trip");
		String place = request.getParameter("place");
		ticket t = ticket.builder()
				.ticketId(0)
				.bookingTime(time)
				.customerName(customer)
				.licensePlate(place)
				.trip(new tripDao().getIdByTripName(trip))
				.build();
		new ticketDao().addTicket(t);
		response.sendRedirect("ticketList");
	}

}
