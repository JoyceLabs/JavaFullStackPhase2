package com.enrollments;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditEnrollmentServlet2")
public class EditEnrollmentServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sStudentId=request.getParameter("studentId");
		int studentId=Integer.parseInt(sStudentId);
		String classId=request.getParameter("classId");
		Enrollment e=new Enrollment();
		e.setStudentId(studentId);
		e.setClassId(classId);
		
		int status=EnrollmentDao.update(e);
		if(status>0){
			response.sendRedirect("ListEnrollments");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
