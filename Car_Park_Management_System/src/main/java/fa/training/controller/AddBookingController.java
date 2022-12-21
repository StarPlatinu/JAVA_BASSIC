package fa.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fa.training.dao.*;
import fa.training.entity.bookingOffice;
import fa.training.entity.employee;
import jakarta.servlet.http.Cookie;

public class AddBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookingController() {
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
        } else {//dang nhap roi
        String accountname = emp.getAccount();
        request.setAttribute("accountname", accountname);
		bookingDao bdao = new bookingDao();
		List<bookingOffice> bookinglist = new ArrayList<>();
		bookinglist = bdao.getAll();	
		request.setAttribute("bookinglist", bookinglist);
		request.getRequestDispatcher("AddBooking.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		tripDao td = new tripDao();
		bookingDao bd = new bookingDao();
		String officename = request.getParameter("officename");
		String trip = request.getParameter("trip");
		String phone = request.getParameter("phone");
		String place = request.getParameter("place");
		String price = request.getParameter("price");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		bookingOffice bf = bookingOffice.builder().officeId(0).endContractDateline(end).officeName(officename).officePhone(phone).officePlace(place).officePrice(price).startContractDeadline(start).tripOb(td.getIdByTripName(trip)).build();
		bd.addBookingOffice(bf);
		response.sendRedirect("bookingList");
	}

}
