package com.ownbank.services;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.http.*;
import com.ownbank.dao.DaoFactory;
import com.ownbank.dao.OwnBankDao;
import com.ownbank.util.User;
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Succ");
		String url="loginn";
		boolean flag=true;
		String passm="";
		String idm="";
		System.out.println("Succ");
		String pass=req.getParameter("Password");
		String id=req.getParameter("Email");
		Pattern p=Pattern.compile("[a-zA-Z][a-zA-Z0-9]*@[a-z]+([.][a-z]+)");
		Matcher mid=p.matcher(id);
		Pattern p3=Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=.]).*$");
		Matcher mpass=p3.matcher(pass);
		Pattern p4=Pattern.compile("[7-9][0-9]{9}");
		if(!mpass.matches()) {
			flag=false;
			passm="Password length must be 8.Atleat one digit[0-9]. Atleast one alpha-char. Atleast one special character[@#$%^&+=.]. No Spaces";
		}
		if(!mid.matches()) {
			flag=false;
			idm="Invalid Email Id";
		}
		if(flag) {
		OwnBankDao owd=DaoFactory.getDao();
		User user=owd.login(id, pass);
		if(user!=null) {
			System.out.println(user);
			HttpSession ses=req.getSession(true);
			ses.setAttribute("user", user);
			ses.setAttribute("blnc", user.getBlnc());
			ses.setAttribute("acc", user.getAccountNo());
			ses.setAttribute("name", user.getName());
			url="after_login.html";
		}else
			req.setAttribute("ms", "Invalid user id or password");
		}else {
			System.out.println("FAiled");
			req.setAttribute("passm", passm);
			req.setAttribute("idm", idm);
		}
		try {
			req.getRequestDispatcher(url).forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}

