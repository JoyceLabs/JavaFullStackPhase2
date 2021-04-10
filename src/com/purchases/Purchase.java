package com.purchases;

import java.util.Date;

public class Purchase {

	private int id;
	private int shoeId;
	private Date purchaseDate;
	private String name;
	private String category;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getShoeId() {
		return shoeId;
	}
	
	public void setShoeId(int shoeId) {
		this.shoeId = shoeId;
	}
	
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
