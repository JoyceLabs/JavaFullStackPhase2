package com.subjects;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListSubjects")
public class ListSubjects extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='AdminMenu.jsp'>Return to Main Menu</a> | <a href='AddSubjectServlet'>Add New Subject</a>");
		out.println("<h1>Subjects List</h1>");
		
		List<Subject> list=SubjectDao.getAllSubjects();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Level</th><th>Edit</th><th>Delete</th></tr>");
		for(Subject s:list){
			out.print("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getLevel()+"</td><td><a href='EditSubjectServlet?id="+s.getId()+"'>edit</a></td><td><a href='DeleteSubjectServlet?id="+s.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
