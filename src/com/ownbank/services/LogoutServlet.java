package com.ownbank.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		HttpSession ses=req.getSession(false);
		ses.removeAttribute("user");
		ses.invalidate();
		req.getRequestDispatcher("loginn").forward(req, res);
	}
}
