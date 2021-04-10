package com.shoes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListShoes")
public class ListShoes extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminMenu.jsp'>Return to Main Menu</a> | <a href='AddShoesServlet'>Add New Shoe</a>");
		out.println("<h1>Shoes List</h1>");
		
		List<Shoe> list=ShoeDao.getAllShoes();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Category</th><th>Edit</th><th>Delete</th></tr>");
		for(Shoe s:list){
			out.print("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getCategory()+"</td><td><a href='EditShoesServlet?id="+s.getId()+"'>edit</a></td><td><a href='DeleteShoesServlet?id="+s.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
