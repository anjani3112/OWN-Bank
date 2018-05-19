package com.ownbank.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.ownbank.dao.DaoFactory;
import com.ownbank.dao.OwnBankDao;
import com.ownbank.util.User;
public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		boolean flag=true;
		String fnm="";
		String lnm="";
		String passm="";
		String rpassm="";
		String idm="";
		String agem="";
		String pm="";
		String rpm="";
		String amtm="";
		String phnm="";
		System.out.println("Succ");
		String fn=req.getParameter("FirstName");
		String ln=req.getParameter("LastName");
		String pass=req.getParameter("Password");
		String rpass=req.getParameter("RePassword");
		String id=req.getParameter("Email");
		String age=req.getParameter("Age");
		int a,pn;
		double at;
		long ph;
		String pin=req.getParameter("Pin");
		String rpin=req.getParameter("RePin");
		String amt=req.getParameter("Amount");
		String phno=req.getParameter("PhoneNumber");
		Pattern p=Pattern.compile("[a-zA-Z][a-zA-Z0-9]*@[a-z]+([.][a-z]+)");
		Matcher mid=p.matcher(id);
		Pattern p2=Pattern.compile("[A-Z][a-z]+");
		Matcher mfn=p2.matcher(fn);
		Matcher mln=p2.matcher(ln);
		Pattern p3=Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=.]).*$");
		Matcher mpass=p3.matcher(pass);
		Pattern p4=Pattern.compile("[7-9][0-9]{9}");
		Matcher mphno=p4.matcher(phno);
		Pattern p5=Pattern.compile("[1-9][0-9]");
		Matcher mage=p5.matcher(age);
		Pattern p6=Pattern.compile("[0-9]{4}");
		Matcher mpin=p6.matcher(pin);
		Pattern p7=Pattern.compile("[0-9]*");
		Matcher mamt=p7.matcher(amt);
		if(!mfn.matches()) {
			fnm="Invalid First Name. Keep First Letter Capital";
			flag=false;
		}
		if(!mln.matches()) {
			flag=false;
			lnm="Invalid Last Name. Keep First Letter Capital";
		}
		if(!mpass.matches()) {
			flag=false;
			passm="Password length must be 8.Atleat one digit[0-9]. Atleast one alpha-char. Atleast one special character[@#$%^&+=.]. No Spaces";
		}
		if(!pass.equals(rpass)) {
			flag=false;
			rpassm="Re-entered password must be same as password";
		}
		if(!mid.matches()) {
			flag=false;
			idm="Invalid Email Id";
		}
		if(!mage.matches()) {
			flag=false;
			agem="Invalid Age. Age between 18-99";
		}
		if(!mpin.matches()) {
			flag=false;
			pm="Pin must be of 4-digits";
		}
		if(!pin.equals(rpin)) {
			flag=false;
			rpm="Re-entered pin must be same as pin";
		}
		if(!mphno.matches()) {
			flag=false;
			phnm="Invalid Phone number";
		}
		if(!mamt.matches()) {
			flag=false;
			amtm="Invalid Amount";
		}
		if(flag) {
		OwnBankDao owd=DaoFactory.getDao();
		if(pass.equals(rpass)&&pin.equals(rpin)){
			pn=Integer.parseInt(pin);
			at=Double.parseDouble(amt);
			a=Integer.parseInt(age);
			ph=Long.parseLong(phno);
			if(owd.registerUser(fn, ln, pn, pass, at, id, a, ph)) {
				System.out.println("Succesful");
				req.getRequestDispatcher("loginn").forward(req, res);
			}
			else
				req.getRequestDispatcher("signin").forward(req, res);
		}
		}
		else {
			req.setAttribute("fnm", fnm);
			req.setAttribute("lnm", lnm);
			req.setAttribute("pm", pm);
			req.setAttribute("rpm", rpm);
			req.setAttribute("passm", passm);
			req.setAttribute("rpassm", rpassm);
			req.setAttribute("amtm", amtm);
			req.setAttribute("phnm", phnm);
			req.setAttribute("agem", agem);
			req.setAttribute("idm", idm);
			req.getRequestDispatcher("signin").forward(req, res);
		}
	}
}
