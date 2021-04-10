package com.shoes;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditShoesServlet")
public class EditShoesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Shoes</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Shoe s=ShoeDao.getShoeById(id);
		
		out.print("<form action='EditShoesServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+s.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' maxlength='50' value='"+s.getName()+"'/></td></tr>");
		out.print("<tr><td>Category:</td><td><input type='text' name='category' maxlength='20' value='"+s.getCategory()+"'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
