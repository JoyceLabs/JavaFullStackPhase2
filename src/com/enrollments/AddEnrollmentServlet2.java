package com.enrollments;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddEnrollmentServlet2")
public class AddEnrollmentServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("studentId");
		int id=Integer.parseInt(sid);
		String classId=request.getParameter("classId");
		
		Enrollment e=new Enrollment();
		e.setStudentId(id);
		e.setClassId(classId);
		
		int status=EnrollmentDao.save(e);
		if(status>0){
			response.sendRedirect("ListEnrollments");
		}else{
			out.println("Sorry! unable to add record");
		}
		
		out.close();
	}

}
