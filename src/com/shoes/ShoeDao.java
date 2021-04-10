package com.shoes;

import java.util.*;
import java.sql.*;

public class ShoeDao {

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
	
	public static int save(Shoe s){
		int status=0;
		try{
			Connection con=ShoeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into shoes(id, name, category) values (?, ?, ?)");
			ps.setInt(1,s.getId());
			ps.setString(2,s.getName());
			ps.setString(3,s.getCategory());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Shoe s){
		int status=0;
		try{
			Connection con=ShoeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update shoes set name=?, category=? where id=?");
			ps.setString(1,s.getName());
			ps.setString(2,s.getCategory());
			ps.setInt(3,s.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=ShoeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from shoes where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Shoe getShoeById(int id){
		Shoe s=new Shoe();
		
		try{
			Connection con=ShoeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from shoes where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setCategory(rs.getString(3));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return s;
	}
	public static List<Shoe> getAllShoes(){
		List<Shoe> list=new ArrayList<Shoe>();
		
		try{
			Connection con=ShoeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT ID, NAME, Category FROM shoes ORDER BY ID ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Shoe s=new Shoe();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setCategory(rs.getString(3));
				list.add(s);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
