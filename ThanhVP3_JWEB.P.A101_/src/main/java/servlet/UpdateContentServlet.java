package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Content;
import model.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import dao.ContentDao;

/**
 * Servlet implementation class UpdateContentServlet
 */
public class UpdateContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ttm= request.getParameter("titlem");
		request.setAttribute("ttm", ttm);
		request.getRequestDispatcher("UpdateContent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContentDao cdao = new ContentDao();
		String ttm= request.getParameter("titlem");
		String Brief = request.getParameter("brief");
		String Content = request.getParameter("content");
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate= DateFor.format(date);
		Random generator = new Random();
		int sort = generator.nextInt(10);
		int authorId = generator.nextInt(10);
		Content c = new Content(ttm, Brief, Content, stringDate, stringDate, sort, authorId);
		cdao.UpdateByTitle(c, ttm);
		response.sendRedirect("viewcontent");
	}

}
