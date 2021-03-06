package com.schoolclasses;

import java.util.*;
import java.sql.*;

public class SchoolClassDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static int save(SchoolClass c){
		int status=0;
		try{
			Connection con=SchoolClassDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Classes (id, semester, subjectid, teacherid) values (?, ?, ?, ?)");
			ps.setString(1,c.getId());
			ps.setString(2,c.getSemester());
			ps.setInt(3,c.getSubjectId());
			ps.setInt(4,c.getTeacherId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(SchoolClass c){
		int status=0;
		try{
			Connection con=SchoolClassDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update Classes set semester=?, subjectId=?, teacherId=? where id=?");
			ps.setString(1,c.getSemester());
			ps.setInt(2,c.getSubjectId());
			ps.setInt(3,c.getTeacherId());
			ps.setString(3,c.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(String id){
		int status=0;
		try{
			Connection con=SchoolClassDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Classes where id=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static SchoolClass getSchoolClassById(String id){
		SchoolClass c=new SchoolClass();
		
		try{
			Connection con=SchoolClassDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Classes where id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				c.setId(rs.getString(1));
				c.setSemester(rs.getString(2));
				c.setSubjectId(rs.getInt(3));
				c.setTeacherId(rs.getInt(4));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return c;
	}
	public static List<SchoolClass> getAllClasses(){
		List<SchoolClass> list=new ArrayList<SchoolClass>();
		
		try{
			Connection con=SchoolClassDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT ID, Semester, Subjectid, teacherId FROM classes ORDER BY ID ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SchoolClass c=new SchoolClass();
				c.setId(rs.getString(1));
				c.setSemester(rs.getString(2));
				c.setSubjectId(rs.getInt(3));
				c.setTeacherId(rs.getInt(4));
				list.add(c);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	public static List<SchoolClass> getAllClassesWithDesc(){
		List<SchoolClass> list=new ArrayList<SchoolClass>();
		
		try{
			Connection con=SchoolClassDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT classes.ID, classes.Semester, Subjects.id, Subjects.NAME, Subjects.level, teachers.id, teachers.name\r\n"
					+ "FROM classes \r\n"
					+ "inner join Subjects\r\n"
					+ "  on classes.SUBJECTID = Subjects.id\r\n"
					+ "inner join teachers\r\n"
					+ "  on classes.teacherid = teachers.id\r\n"
					+ "ORDER BY ID");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SchoolClass c=new SchoolClass();
				c.setId(rs.getString(1));
				c.setSemester(rs.getString(2));
				c.setSubjectId(rs.getInt(3));
				c.setSubjectName(rs.getString(4));
				c.setSubjectLevel(rs.getString(5));
				c.setTeacherId(rs.getInt(6));
				c.setTeacherName(rs.getString(7));
				list.add(c);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	public static List<SchoolClass> getAllClassInfo(){
		List<SchoolClass> list=new ArrayList<SchoolClass>();
		
		try{
			Connection con=SchoolClassDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT classes.ID, classes.Semester, classes.Subjectid, subjects.name, subjects.level, classes.teacherId, teachers.name, teachers.email, enrollments.studentid, students.name, students.email\r\n"
					+ "FROM classes \r\n"
					+ "inner join subjects\r\n"
					+ "  on classes.subjectid = subjects.id\r\n"
					+ "inner join teachers\r\n"
					+ "  on classes.teacherid = teachers.id\r\n"
					+ "inner join enrollments\r\n"
					+ "  on classes.id = enrollments.classid\r\n"
					+ "inner join students\r\n"
					+ "  on enrollments.studentid = students.id\r\n"
					+ "ORDER BY ID");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SchoolClass c=new SchoolClass();
				c.setId(rs.getString(1));
				c.setSemester(rs.getString(2));
				c.setSubjectId(rs.getInt(3));
				c.setSubjectName(rs.getString(4));
				c.setSubjectLevel(rs.getString(5));
				c.setTeacherId(rs.getInt(6));
				c.setTeacherName(rs.getString(7));
				c.setTeacherEmail(rs.getString(8));
				c.setStudentId(rs.getInt(9));
				c.setStudentName(rs.getString(10));
				c.setStudentEmail(rs.getString(11));
				list.add(c);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}

}
