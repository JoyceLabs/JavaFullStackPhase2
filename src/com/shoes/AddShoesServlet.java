package com.shoes;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddShoesServlet")
public class AddShoesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Add Shoes</h1>");
		
		out.print("<form action='AddShoesServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td>ID:</td><td><input type='number' name='id' maxlength='10' value=''/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' maxlength='50' value=''/></td></tr>");
		out.print("<tr><td>Category:</td><td><input type='text' name='category' maxlength='20' value=''/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
