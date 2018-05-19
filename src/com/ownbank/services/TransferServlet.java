package com.ownbank.services;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.http.*;
import com.ownbank.dao.DaoFactory;
import com.ownbank.dao.OwnBankDao;
import com.ownbank.util.User;
public class TransferServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Succ");
		boolean flag=true;
		String pm="";
		String amtm="";
		String bm="";
		String ben=req.getParameter("Benfiaciary");
		String pin=req.getParameter("Pin");		
		String amt=req.getParameter("Amount");	
		Pattern p6=Pattern.compile("[0-9]{4}");
		Matcher mpin=p6.matcher(pin);
		Pattern p7=Pattern.compile("[0-9]*");
		Matcher mamt=p7.matcher(amt);
		Pattern p=Pattern.compile("[1][0-9]{10}");
		Matcher mben=p.matcher(ben);
		if(!mpin.matches()) {
			flag=false;
			pm="Pin must be of 4-digits";
		}
		if(!mben.matches()) {
			flag=false;
			bm="Account no. must be of 11-digits";
		}
		if(!mamt.matches()) {
			flag=false;
			amtm="Invalid Amount";
		}
		if(flag) {
		HttpSession ses=req.getSession(false);
		User user=(User)ses.getAttribute("user");
		long payee=user.getAccountNo();
		long benf=Long.parseLong(ben);
		double amtt=Double.parseDouble(amt);
		if(user.getBlnc()>amtt) {
		OwnBankDao owd=DaoFactory.getDao();
		String msg=owd.transfer(benf, payee, amtt);
		System.out.println(msg);
		if(msg.equals("Transaction Successful")) {
			user.setBlnc(user.getBlnc()-amtt);
			ses.setAttribute("user", user);
			ses.setAttribute("blnc", user.getBlnc());
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("success").forward(req, res);
		}
		else {
			amtm="Insufficient Balance";
			flag=false;
		}

	}
	else if(!flag) {
		req.setAttribute("bm", bm);
		req.setAttribute("pm", pm);
		req.setAttribute("amtm", amtm);
		req.getRequestDispatcher("transferr").forward(req, res);	
	}
	}
}