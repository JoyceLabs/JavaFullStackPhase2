package com.students;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListMasterStudents")
public class ListMasterStudents extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminMenu.jsp'>Return to Main Menu</a>");
		out.println("<h1>Students Master List</h1>");
		
		List<Student> list=StudentDao.getAllStudentsInClasses();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Semester</th><th>Subject Name</th><th>Teacher Name</th></tr>");
		
		for(Student s:list){
			out.print("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getEmail()+"</td><td>"+s.getSemester()+"</td><td>"+s.getSubjectName()+"</td><td>"+s.getTeacherName()+"</td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
