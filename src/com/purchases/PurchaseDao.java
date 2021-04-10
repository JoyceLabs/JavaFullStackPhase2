package com.purchases;

import java.util.*;
import java.sql.*;

public class PurchaseDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static List<Purchase> getAllPurchaseInfo(){
		List<Purchase> list=new ArrayList<Purchase>();
		
		try{
			Connection con=PurchaseDao.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT Purchases.ID, Purchases.ShoeId, Shoes.Name, Purchases.PurchaseDate, Shoes.Category\r\n"
					+ "FROM Purchases \r\n"
					+ "inner join shoes\r\n"
					+ "  on Purchases.shoeId = shoes.id\r\n"
					+ "ORDER BY ID");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Purchase c=new Purchase();
				c.setId(rs.getInt(1));
				c.setShoeId(rs.getInt(2));
				c.setName(rs.getString(3));
				c.setPurchaseDate(rs.getDate(4));
				c.setCategory(rs.getString(5));
				list.add(c);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}

}
