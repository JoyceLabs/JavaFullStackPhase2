package com.schoolclasses;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListSchoolClasses")
public class ListSchoolClasses extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminMenu.jsp'>Return to Main Menu</a> | <a href='AddSchoolClassServlet'>Add New School Class</a>");
		out.println("<h1>School Class List</h1>");
		
		List<SchoolClass> list=SchoolClassDao.getAllClasses();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Semester</th><th>Subjectid</th><th>Teacherid</th><th>Edit</th><th>Delete</th></tr>");
		for(SchoolClass c:list){
			out.print("<tr><td>"+c.getId()+"</td><td>"+c.getSemester()+"</td><td>"+c.getSubjectId()+"</td><td>"+c.getTeacherId()+"</td><td><a href='EditSchoolClassServlet?id="+c.getId()+"'>edit</a></td><td><a href='DeleteSchoolClassServlet?id="+c.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
