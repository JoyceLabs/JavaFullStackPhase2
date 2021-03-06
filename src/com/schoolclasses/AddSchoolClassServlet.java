package com.schoolclasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subjects.Subject;
import com.subjects.SubjectDao;
import com.teachers.Teacher;
import com.teachers.TeacherDao;

@WebServlet("/AddSchoolClassServlet")
public class AddSchoolClassServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<Subject> subjectList=SubjectDao.getAllSubjects();
		List<Teacher> teacherList=TeacherDao.getAllTeachers();

		out.println("<h1>Add SchoolClass</h1>");
		
		out.print("<form action='AddSchoolClassServlet2' method='post'>");
		out.print("<table>");
		
		out.print("<tr><td>ID:</td><td><input type='text' name='id' maxlength='10' value=''/></td></tr>");

		out.print("<tr><td>Semester:</td><td><select name='semester' style='width:250px'>");
		out.print("<option value='Winter'>Winter</option>");
		out.print("<option value='Spring'>Spring</option>");
		out.print("<option value='Summer'>Summer</option>");
		out.print("<option value='Fall' selected>Fall</option>");
		out.print("</select></td></tr>");
		
		out.print("<tr><td>Subject:</td><td><select name='subjectId' style='width:250px'>");
		for(Subject s:subjectList){
			out.print("<option value=" + s.getId() + ">" + s.getId() + " " + s.getName() + " " + s.getLevel() + "</option>");
		}
		out.print("</select></td></tr>");
		
		out.print("<tr><td>Teacher:</td><td><select name='teacherId' style='width:250px'>");
		for(Teacher t:teacherList){
			out.print("<option value=" + t.getId() + ">" + t.getId() + " " + t.getName() + "</option>");
		}
		out.print("</select></td></tr>");
		
		out.print("<tr><td></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
