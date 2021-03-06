package com.students;

import java.util.*;
import java.sql.*;

public class StudentDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static int save(Student s){
		int status=0;
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into students (id, name, email) values (?, ?, ?)");
			ps.setInt(1,s.getId());
			ps.setString(2,s.getName());
			ps.setString(3,s.getEmail());
			
			System.out.println("before execute update"+ps);
			status=ps.executeUpdate();
			System.out.println("after execute update");
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Student s){
		int status=0;
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update students set name=?, email=? where id=?");
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setInt(3,s.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from students where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			System.out.println("after execute id was "+id);
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Student getStudentById(int id){
		Student s=new Student();
		
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from students where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return s;
	}
	public static List<Student> getAllStudents(){
		List<Student> list=new ArrayList<Student>();
		
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT ID, NAME, EMAIL FROM students ORDER BY ID ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				list.add(s);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}

	public static List<Student> getAllStudentsInClasses(){
		List<Student> list=new ArrayList<Student>();
		
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT students.ID, students.NAME, students.EMAIL, classes.semester, subjects.name, teachers.name\r\n"
					+ "FROM students \r\n"
					+ "inner join enrollments\r\n"
					+ "on  students.ID = enrollments.STUDENTID\r\n"
					+ "inner join classes\r\n"
					+ "on enrollments.classid = classes.id\r\n"
					+ "inner join teachers\r\n"
					+ "on classes.teacherid = teachers.id\r\n"
					+ "inner join subjects\r\n"
					+ "on subjects.id = classes.subjectid\r\n"
					+ "ORDER BY ID");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setSemester(rs.getString(4));
				s.setSubjectName(rs.getString(5));
				s.setTeacherName(rs.getString(6));
				list.add(s);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
