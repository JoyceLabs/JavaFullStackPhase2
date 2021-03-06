package com.subjects;

import java.util.*;
import java.sql.*;

public class SubjectDao {

	public static Connection getConnection(){
		Connection con=null;
		try{			
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	
	public static int save(Subject s){
		int status=0;
		try{
			Connection con=SubjectDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into subjects(id, name, level) values (?, ?, ?)");
			ps.setInt(1,s.getId());
			ps.setString(2,s.getName());
			ps.setString(3,s.getLevel());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Subject s){
		int status=0;
		try{
			Connection con=SubjectDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update subjects set name=?, level=? where id=?");
			ps.setString(1,s.getName());
			ps.setString(2,s.getLevel());
			ps.setInt(3,s.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=SubjectDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from subjects where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Subject getSubjectById(int id){
		Subject s=new Subject();
		
		try{
			Connection con=SubjectDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from subjects where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setLevel(rs.getString(3));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return s;
	}
	public static List<Subject> getAllSubjects(){
		List<Subject> list=new ArrayList<Subject>();
		
		try{
			Connection con=SubjectDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT ID, NAME, LEVEL FROM subjects ORDER BY ID ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Subject s=new Subject();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setLevel(rs.getString(3));
				list.add(s);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
