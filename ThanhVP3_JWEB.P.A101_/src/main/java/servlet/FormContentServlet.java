package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import dao.ContentDao;
import model.Content;
/**
 * Servlet implementation class FormContentServlet
 */
public class FormContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user");
		if(user!=null) {
		request.getRequestDispatcher("form-content.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContentDao cdao = new ContentDao();
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user");
		String uname = user.getUsername();
		String password = user.getPassword();	
		String Title = request.getParameter("title");
		String Brief = request.getParameter("brief");
		String Content = request.getParameter("content");
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate= DateFor.format(date);
		Random generator = new Random();
		int sort = generator.nextInt(10);
		int authorId = generator.nextInt(10);
		Content c = new Content(Title, Brief, Content, stringDate, stringDate, sort, authorId);
		cdao.addContent(c);
		response.sendRedirect("viewcontent");
	}

}
