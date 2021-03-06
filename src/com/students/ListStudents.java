package com.students;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListStudents")
public class ListStudents extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminMenu.jsp'>Return to Main Menu</a> | <a href='AddStudentServlet'>Add New Student</a>");
		out.println("<h1>Students List</h1>");
		
		List<Student> list=StudentDao.getAllStudents();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Edit</th><th>Delete</th></tr>");
		for(Student s:list){
			out.print("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getEmail()+"</td><td><a href='EditStudentServlet?id="+s.getId()+"'>edit</a></td><td><a href='DeleteStudentServlet?id="+s.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
