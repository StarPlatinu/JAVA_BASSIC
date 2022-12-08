package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.TransactionHistory;

import java.io.IOException;
import java.util.List;

import dao.AccountDao;
import dao.TransactionDao;

/**
 * Servlet implementation class TransferServlet
 */
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Account acc =(Account)session.getAttribute("account");
		if(acc!=null) {
			List<Account> list = new AccountDao().getAllAccount();
			request.setAttribute("list", list);
			int balance = acc.getBalance();
			request.setAttribute("balance", balance);
			String accountname = acc.getAccount();
			request.setAttribute("accname", accountname);
			request.getRequestDispatcher("transfer.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Account acc =(Account)session.getAttribute("account");
		List<Account> list = new AccountDao().getAllAccount();
		request.setAttribute("list", list);
		int balance = acc.getBalance();
		int amount = Integer.parseInt(request.getParameter("amount"));
		String acctransfer = request.getParameter("acctransfer");
		String note = request.getParameter("note");
		TransactionDao tdao = new TransactionDao();
		AccountDao adao = new AccountDao();
		int newbalance = balance = amount;
		TransactionHistory th = new TransactionHistory(newbalance, note, acctransfer);
		Account act = AccountDao.getAnAccountByAccName(acctransfer);
		int actupdatebalance = act.getBalance() + amount;
		
	}

}
