package com.teachers;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListTeachers")
public class ListTeachers extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminMenu.jsp'>Return to Main Menu</a> | <a href='AddTeacherServlet'>Add New Teacher</a>");
		out.println("<h1>Teachers List</h1>");
		
		List<Teacher> list=TeacherDao.getAllTeachers();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Edit</th><th>Delete</th></tr>");
		for(Teacher t:list){
			out.print("<tr><td>"+t.getId()+"</td><td>"+t.getName()+"</td><td>"+t.getEmail()+"</td><td><a href='EditTeacherServlet?id="+t.getId()+"'>edit</a></td><td><a href='DeleteTeacherServlet?id="+t.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
