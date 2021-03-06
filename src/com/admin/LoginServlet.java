package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String login=request.getParameter("LoginName");
		String pass=request.getParameter("Password");
		
		if (login.equals("admin") && pass.equals("manager")) {
			HttpSession session=request.getSession();
			session.setAttribute("login", login);
		    response.sendRedirect("AdminMenu.jsp");
		}else {
			out.println("Your login is not valid.  Please contact your system administrator.");
		}
	}

}
