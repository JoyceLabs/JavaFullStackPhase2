package com.schoolclasses;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditSchoolClassServlet2")
public class EditSchoolClassServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		String semester=request.getParameter("semester");
		String ssubjectId=request.getParameter("subjectId");
		int subjectId=Integer.parseInt(ssubjectId);
		String steacherId=request.getParameter("teacherId");
		int teacherId=Integer.parseInt(steacherId);
		
		SchoolClass c=new SchoolClass();
		c.setId(sid);
		c.setSemester(semester);
		c.setSubjectId(subjectId);
		c.setTeacherId(teacherId);
		
		int status=SchoolClassDao.update(c);
		if(status>0){
			response.sendRedirect("ListSchoolClasses");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
