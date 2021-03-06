<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>
</head>
<body>
	<h1 align="center">Welcome to the Learner's Academy</h1>
	<h1 align="center">Administration Menu</h1>
	<h1 align="left">Welcome <%= session.getAttribute("login") %>!  |  <a href="logout.jsp">logout</a></h1></br>
	
<form >
	<h1 align="left"><a href="ListSubjects">Subjects</a>  |  <a href="ListTeachers">Teachers</a>  |  <a href="ListStudents">Students</a>  |  <a href="ListSchoolClasses">Classes</a>  |  <a href="ListEnrollments">Enrollments</a>  |  <a href="ListMasterStudents">Master Student List</a>  |  <a href="ListSchoolClassReport">Class Report</a></h1></br>
</form>

</body>
</html>