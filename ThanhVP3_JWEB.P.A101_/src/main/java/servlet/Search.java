package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.ContentDao;
import model.*;
/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContentDao cd = new ContentDao();
		String title = "";
	    title = request.getParameter("data");	
		List<Content> list = cd.getContentByTitle(title);
		request.setAttribute("list", list);
		request.getRequestDispatcher("SearchContentByTitle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContentDao cd = new ContentDao();
		String title = "";
	    title = request.getParameter("data");	
		List<Content> list = cd.getContentByTitle(title);
		request.setAttribute("list", list);
		request.getRequestDispatcher("SearchContentByTitle.jsp").forward(request, response);	
		
	}
	
}
