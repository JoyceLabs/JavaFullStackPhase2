package com.students;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditStudentServlet2")
public class EditStudentServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		Student s=new Student();
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		
		int status=StudentDao.update(s);
		if(status>0){
			response.sendRedirect("ListStudents");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
