package com.teachers;

import java.util.*;
import java.sql.*;

public class TeacherDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static int save(Teacher t){
		int status=0;
		try{
			Connection con=TeacherDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into teachers(id,name,email) values (?, ?, ?)");
			ps.setInt(1,t.getId());
			ps.setString(2,t.getName());
			ps.setString(3,t.getEmail());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Teacher t){
		int status=0;
		try{
			Connection con=TeacherDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update teachers set name=?, email=? where id=?");
			ps.setString(1,t.getName());
			ps.setString(2,t.getEmail());
			ps.setInt(3,t.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=TeacherDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from teachers where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Teacher getTeacherById(int id){
		Teacher t=new Teacher();
		
		try{
			Connection con=TeacherDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from teachers where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return t;
	}
	public static List<Teacher> getAllTeachers(){
		List<Teacher> list=new ArrayList<Teacher>();
		
		try{
			Connection con=TeacherDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT ID, NAME, EMAIL FROM teachers ORDER BY ID ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Teacher t=new Teacher();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setEmail(rs.getString(3));
				list.add(t);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
