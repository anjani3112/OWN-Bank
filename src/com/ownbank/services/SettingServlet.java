package com.ownbank.services;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ownbank.dao.DaoFactory;
import com.ownbank.dao.OwnBankDao;
import com.ownbank.util.User;

public class SettingServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Succ");
		String opm="";
		String pm="";
		String rpm="";
		boolean flag=true;
		String opin=req.getParameter("OldPin");
		String npin=req.getParameter("NewPin");
		String repin=req.getParameter("RePin");
		Pattern p6=Pattern.compile("[0-9]{4}");
		Matcher mpin=p6.matcher(opin);
		Matcher mnpin=p6.matcher(npin);
		if(!mpin.matches()) {
			flag=false;
			pm="Pin must be of 4-digits";
		}
		if(!mpin.matches()) {
			flag=false;
			pm="Pin must be of 4-digits";
		}
		if(!npin.equals(repin)) {
			flag=false;
			rpm="Re-entered pin must be same as pin";
		}
		
		if(flag) {
		HttpSession ses=req.getSession(false);
		User user=(User)ses.getAttribute("user");
		long payee=user.getAccountNo();
		int old=Integer.parseInt(opin);
		int pin=Integer.parseInt(npin);
		int rpin=Integer.parseInt(repin);
		if(old==user.getPin()&&pin==rpin) {
		OwnBankDao owd=DaoFactory.getDao();
		String msg=owd.setting(pin,payee);
		System.out.println(msg);
		if(msg.equals("Successful")) {
			user.setPin(pin);
			ses.setAttribute("user", user);
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("success").forward(req, res);
		}
		else {
			flag=false;
			opm="Wrong PIN";}
		}
	else if(!flag) {
	req.setAttribute("pm", pm);
	req.setAttribute("rpm", rpm);
	req.setAttribute("opm", opm);
	req.getRequestDispatcher("settingg").forward(req, res);}
	}
}
