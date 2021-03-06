package com.teachers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditTeacherServlet2")
public class EditTeacherServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		Teacher t=new Teacher();
		t.setId(id);
		t.setName(name);
		t.setEmail(email);
		
		int status=TeacherDao.update(t);
		if(status>0){
			response.sendRedirect("ListTeachers");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
