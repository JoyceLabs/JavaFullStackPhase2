package com.enrollments;

import java.util.*;
import java.sql.*;

public class EnrollmentDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static int save(Enrollment e){
		int status=0;
		try{
			Connection con=EnrollmentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into enrollments(studentId, classId) values (?, ?)");
			ps.setInt(1,e.getStudentId());
			ps.setString(2,e.getClassId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Enrollment e){
		int status=0;
		try{
			Connection con=EnrollmentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update enrollments set classId=? where studentId=?");
			ps.setString(1,e.getClassId());
			ps.setInt(2,e.getStudentId());
			
			System.out.println("inside update "+ps);
			status=ps.executeUpdate();
			System.out.println("after update ");
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int studentId){
		int status=0;
		try{
			Connection con=EnrollmentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from enrollments where studentId=?");
			ps.setInt(1,studentId);
			System.out.println("before execute update");
			status=ps.executeUpdate();
			System.out.println("after execute update");
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Enrollment getEnrollmentById(int studentId){
		Enrollment e=new Enrollment();
		
		try{
			Connection con=EnrollmentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select studentId, classId from enrollments where studentId=?");
			ps.setInt(1,studentId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setStudentId(rs.getInt(1));
				e.setClassId(rs.getString(2));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Enrollment> getAllEnrollments(){
		List<Enrollment> list=new ArrayList<Enrollment>();
		
		try{
			Connection con=EnrollmentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT StudentId, ClassId FROM enrollments ORDER BY ClassId ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Enrollment e=new Enrollment();
				e.setStudentId(rs.getInt(1));
				e.setClassId(rs.getString(2));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
