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

@WebServlet("/EditEnrollmentServlet")
public class EditEnrollmentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<SchoolClass> schoolClassList=SchoolClassDao.getAllClassesWithDesc();

		out.println("<h1>Update Enrollment</h1>");
		String sstudentId=request.getParameter("id");
		int studentId=Integer.parseInt(sstudentId);
		
		Enrollment e=EnrollmentDao.getEnrollmentById(studentId);
		
		out.print("<form action='EditEnrollmentServlet2' method='post'>");
		out.print("<table>");
		
		out.print("<tr><td></td><td><input type='hidden' name='studentId' value='"+e.getStudentId()+"'/></td></tr>");
		
		out.print("<tr><td>Class ID:</td><td><select name='classId' style='width:200px'>");
		for(SchoolClass c:schoolClassList){
			if (c.getId() == e.getClassId()) {
				out.print("<option value=" + c.getId() + " selected>" + c.getId() + " " + c.getSemester() + " " + c.getSubjectName() + " " + c.getTeacherName() + "</option>");
			} else {
				out.print("<option value=" + c.getId() + ">" + c.getId() + " " + c.getSemester() + " " + c.getSubjectName() + " " + c.getTeacherName() + "</option>");
			}
		}
		out.print("</select></td></tr>");
		
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
