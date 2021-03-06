package com.enrollments;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListEnrollments")
public class ListEnrollments extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminMenu.jsp'>Return to Main Menu</a> | <a href='AddEnrollmentServlet'>Add New Enrollment</a>");
		out.println("<h1>Enrollments List</h1>");
		
		List<Enrollment> list=EnrollmentDao.getAllEnrollments();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Student Id</th><th>Class Id</th><th>Edit</th><th>Delete</th></tr>");
		for(Enrollment e:list){
			out.print("<tr><td>"+e.getStudentId()+"</td><td>"+e.getClassId()+"</td><td><a href='EditEnrollmentServlet?id="+e.getStudentId()+"'>edit</a></td><td><a href='DeleteEnrollmentServlet?id="+e.getStudentId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
