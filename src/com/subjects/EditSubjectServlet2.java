package com.subjects;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditSubjectServlet2")
public class EditSubjectServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String level=request.getParameter("level");
		
		Subject s=new Subject();
		s.setId(id);
		s.setName(name);
		s.setLevel(level);
		
		int status=SubjectDao.update(s);
		if(status>0){
			response.sendRedirect("ListSubjects");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
