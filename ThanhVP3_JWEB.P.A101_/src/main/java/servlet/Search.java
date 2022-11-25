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
		int page, numperpage = 3;
		int size = list.size();
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
		List<Content> listPerPage = cd.getListByPage(list, start, end);
		
		request.setAttribute("listPerPage", listPerPage);
		request.setAttribute("data", title);
		request.setAttribute("page", page);
		request.setAttribute("num", num);
		
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
