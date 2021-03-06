package com.enrollments;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEnrollmentServlet")
public class DeleteEnrollmentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sStudentId=request.getParameter("id");
		System.out.println("student id is "+sStudentId);
		int studentId=Integer.parseInt(sStudentId);
		System.out.println("before dao execute update");
		EnrollmentDao.delete(studentId);
		System.out.println("after dao delete");
		response.sendRedirect("ListEnrollments");
	}
}
