package com.purchases;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListPurchaseReport")
public class ListPurchaseReport extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminMenu.jsp'>Return to Main Menu</a>");
		out.println("<h1>Purchases Report</h1>");
		
		List<Purchase> list=PurchaseDao.getAllPurchaseInfo();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Shoe Id</th><th>Name</th><th>Category</th><th>Purchase Date</th></tr>");

		for(Purchase c:list){
			out.print("<tr><td>"+c.getId()+"</td><td>"+c.getShoeId()+"</td><td>"+c.getName()+"</td><td>"+c.getCategory()+"</td><td>"+c.getPurchaseDate()+"</td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
