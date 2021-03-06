package com.enrollments;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolclasses.SchoolClass;
import com.schoolclasses.SchoolClassDao;
import com.students.Student;
import com.students.StudentDao;
import com.subjects.Subject;
import com.subjects.SubjectDao;

@WebServlet("/AddEnrollmentServlet")
public class AddEnrollmentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<Student> studentList=StudentDao.getAllStudents();
		List<SchoolClass> schoolClassList=SchoolClassDao.getAllClassesWithDesc();

		out.println("<h1>Add Enrollment</h1>");
		
		out.print("<form action='AddEnrollmentServlet2' method='post'>");
		out.print("<table>");
		
		out.print("<tr><td>Student ID:</td><td><select name='studentId' style='width:200px'>");
		for(Student s:studentList){
			out.print("<option value=" + s.getId() + ">" + s.getId() + " " + s.getName() + "</option>");
		}
		out.print("</select></td></tr>");
		
		out.print("<tr><td>Class ID:</td><td><select name='classId' style='width:200px'>");
		for(SchoolClass c:schoolClassList){
			out.print("<option value=" + c.getId() + ">" + c.getId() + " " + c.getSemester() + " " + c.getSubjectName() + " " + c.getTeacherName() + "</option>");
		}
		out.print("</select></td></tr>");
		
		out.print("<tr><td colspan='2'><input type='submit' value='Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
