package com.schoolclasses;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListSchoolClassReport")
public class ListSchoolClassReport extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminMenu.jsp'>Return to Main Menu</a>");
		out.println("<h1>Class Report</h1>");
		
		List<SchoolClass> list=SchoolClassDao.getAllClassInfo();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Semester</th><th>Subject id</th><th>Subject Name</th><th>Subject Level</th><th>Teacher Id</th><th>Teacher Name</th><th>Teacher Email</th><th>Student Id</th><th>Student Name</th><th>Student Email</th></tr>");

		for(SchoolClass c:list){
			out.print("<tr><td>"+c.getId()+"</td><td>"+c.getSemester()+"</td><td>"+c.getSubjectId()+"</td><td>"+c.getSubjectName()+"</td><td>"+c.getSubjectLevel()+"</td><td>"+c.getTeacherId()+"</td><td>"+c.getTeacherName()+"</td><td>"+c.getTeacherEmail()+"</td><td>"+c.getStudentId()+"</td><td>"+c.getStudentName()+"</td><td>"+c.getStudentEmail()+"</td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
