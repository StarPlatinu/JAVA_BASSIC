package fa.training.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fa.training.entity.*;
import fa.training.dao.*;

public class BookingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		bookingDao bdao = new bookingDao();
		List<bookingOffice> bookinglist = new ArrayList<>();
		String name = "";
		if(request.getParameter("data")!=null) {
	    name = request.getParameter("data");	
		}
		bookinglist = bdao.getBookingOfficeByName(name);
		int page, numperpage = 3;
		int size = bookinglist.size();
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
		List<bookingOffice> listPerPage = bdao.getListByPage(bookinglist, start, end);
		request.setAttribute("listPerPage", listPerPage);
		request.setAttribute("bookinglist", bookinglist);
		request.setAttribute("page", page);
		request.setAttribute("num", num);
		request.setAttribute("data", name);
		request.getRequestDispatcher("BookingList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		bookingDao bdao = new bookingDao();
		String name = "";
		name =	request.getParameter("data");
		List<bookingOffice> bookinglist = new ArrayList<>();
		bookinglist = bdao.getBookingOfficeByName(name);
		int page, numperpage = 3;
		int size = bookinglist.size();
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
		List<bookingOffice> listPerPage = bdao.getListByPage(bookinglist, start, end);
		request.setAttribute("listPerPage", listPerPage);
		request.setAttribute("bookinglist", bookinglist);
		request.setAttribute("page", page);
		request.setAttribute("num", num);
		request.setAttribute("data", name);
		request.getRequestDispatcher("BookingList.jsp").forward(request, response);
	}

}
