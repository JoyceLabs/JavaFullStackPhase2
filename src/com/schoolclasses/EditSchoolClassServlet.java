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

@WebServlet("/EditSchoolClassServlet")
public class EditSchoolClassServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Class</h1>");
		String sid=request.getParameter("id");
		
		List<Subject> subjectList=SubjectDao.getAllSubjects();
		List<Teacher> teacherList=TeacherDao.getAllTeachers();
		
		SchoolClass c=SchoolClassDao.getSchoolClassById(sid);
		
		out.print("<form action='EditSchoolClassServlet2' method='post'>");
		out.print("<table>");
		
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+c.getId()+"'/></td></tr>");
		
		out.print("<tr><td>Semester:</td><td><select name='semester' style='width:250px'>");
		switch (c.getSemester()) {
          case "Winter":  
	      		out.print("<option value='Winter' selected>Winter</option>");
	    		out.print("<option value='Spring'>Spring</option>");
	    		out.print("<option value='Summer'>Summer</option>");
	    		out.print("<option value='Fall'>Fall</option>");
                 break;
          case "Spring":  
	      		out.print("<option value='Winter'>Winter</option>");
	    		out.print("<option value='Spring' selected>Spring</option>");
	    		out.print("<option value='Summer'>Summer</option>");
	    		out.print("<option value='Fall'>Fall</option>");
                 break;
          case "Summer":  
	      		out.print("<option value='Winter'>Winter</option>");
	    		out.print("<option value='Spring'>Spring</option>");
	    		out.print("<option value='Summer' selected>Summer</option>");
	    		out.print("<option value='Fall'>Fall</option>");
                 break;
          default: 
	      		out.print("<option value='Winter'>Winter</option>");
	    		out.print("<option value='Spring'>Spring</option>");
	    		out.print("<option value='Summer'>Summer</option>");
	    		out.print("<option value='Fall' selected>Fall</option>");
                 break;
		}		
		out.print("</select></td></tr>");
		
		out.print("<tr><td>Subject:</td><td><select name='subjectId' style='width:250px'>");
		for(Subject s:subjectList){
			if (s.getId() == c.getSubjectId()) {
				out.print("<option value=" + s.getId() + " selected>" + s.getId() + " " + s.getName() + " " + s.getLevel() + "</option>");
			} else {
				out.print("<option value=" + s.getId() + ">" + s.getId() + " " + s.getName() + " " + s.getLevel() + "</option>");
			}
		}
		out.print("</select></td></tr>");
		
		out.print("<tr><td>Teacher:</td><td><select name='teacherId' style='width:250px'>");
		for(Teacher t:teacherList){
			if (t.getId() == c.getTeacherId()) {
				out.print("<option value=" + t.getId() + " selected>" + t.getId() + " " + t.getName() + "</option>");
			} else {
				out.print("<option value=" + t.getId() + ">" + t.getId() + " " + t.getName() + "</option>");
			}
		}
		out.print("</select></td></tr>");
		
		out.print("<tr><td></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
