package com.teachers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditTeacherServlet")
public class EditTeacherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Teacher</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Teacher t=TeacherDao.getTeacherById(id);
		
		out.print("<form action='EditTeacherServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+t.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' maxlength='50' value='"+t.getName()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' maxlength='20' value='"+t.getEmail()+"'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}