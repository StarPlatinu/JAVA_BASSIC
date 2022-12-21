package fa.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.parkingDao;
import fa.training.entity.employee;
import fa.training.entity.parkingLot;

public class AddParkingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddParkingController() {
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
		List<parkingLot> list = new ArrayList<>();
		list = new parkingDao().getAllparkinglot();
		request.setAttribute("parkinglot", list);
	request.getRequestDispatcher("AddParkingLot.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String parkName = request.getParameter("parkingname");
		String place = request.getParameter("parkingplace");
		String area = request.getParameter("parkingarea");
		String price = request.getParameter("parkingprice");
		
		parkingLot lot = parkingLot.builder()
				.parkArea(Double.parseDouble(area))
				.parkName(parkName)
				.parkPlace(place)
				.parkPrice(price)
				.parkStatus("None")
				.build();
		new parkingDao().addParking(lot);
		response.sendRedirect("parkingList");
	}

}
