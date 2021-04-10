package com.shoes;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddShoesServlet2")
public class AddShoesServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		
		Shoe s=new Shoe();
		s.setId(id);
		s.setName(name);
		s.setCategory(category);
		
		int status=ShoeDao.save(s);
		if(status>0){
			response.sendRedirect("ListShoes");
		}else{
			out.println("Sorry! unable to add record");
		}
		
		out.close();
	}

}
