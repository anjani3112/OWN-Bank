package com.ownbank.services;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import com.ownbank.dao.DaoFactory;
import com.ownbank.dao.OwnBankDao;
import com.ownbank.util.Transaction;
import com.ownbank.util.User;
public class TransactionServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Succ");
		ArrayList<Transaction> al=null;
		HttpSession ses=req.getSession(false);
		User user=(User)ses.getAttribute("user");
		long payee=user.getAccountNo();
		OwnBankDao owd=DaoFactory.getDao();
		al=owd.transactions(payee);
		if(al.isEmpty()) {
			req.setAttribute("msg", "No Transaction Details found");
			req.getRequestDispatcher("success").include(req, res);
		}
		else {
			PrintWriter pw=res.getWriter();
			pw.print("<div align=\"center\"><h1>Transaction Details</h1>\r\n" + 
					"<table>\r\n" + 
					"<th>Transaction Id</th>\r\n" + 
					"<th>Benefiaciary</th>\r\n" + 
					"<th>Type</th>\r\n" + 
					"<th>Date</th>\r\n" + 
					"<th>Amount</th>\r\n" + 
					"<tr>\r\n" + 
					"<td>");
			for(int i=0;i<al.size();i++) {
				Transaction t=al.get(i);
				String name=t.getName();
				if(name.equals(user.getName()))
					name="Self";
				pw.print("<tr>\r\n" + 
						"<td>"+t.getTxn_id()+"</td>\r\n" + 
						"<td>"+name+"</td>\r\n" + 
						"<td>"+t.getType()+"</td>\r\n" + 
						"<td>"+t.getD()+"</td>\r\n" + 
						"<td>"+t.getAmt()+"</td>\r\n" + 
						"</tr>\r\n");
			}
			pw.println("</table>\r\n" + 
						"</div>");
		}
	}
}