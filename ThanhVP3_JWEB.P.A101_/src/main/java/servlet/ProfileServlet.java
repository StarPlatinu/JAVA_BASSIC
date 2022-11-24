package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.core.Response;
import model.Member;
import model.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.ProfileDao;
/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
		request.getRequestDispatcher("profile.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProfileDao pd = new ProfileDao();
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user");
		String uname = user.getUsername();
		String password = user.getPassword();
		Member check = pd.getMemberByUsername(uname);
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate= DateFor.format(date);
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = user.getUsername();
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String decription = request.getParameter("decription");
		String CreatedDate = stringDate;
		String UpdateTime = stringDate;
		Member m = new Member(firstname, lastname, username, password, phone, email, decription, CreatedDate, UpdateTime);
	
		if(check==null) {		
		pd.addNewProfile(m);
		response.sendRedirect("profile");
		}
		else {
		pd.updateProfile(m,uname);
		response.sendRedirect("viewcontent");
		}
	}

}
