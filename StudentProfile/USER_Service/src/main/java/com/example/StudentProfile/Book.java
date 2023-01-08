package com.example.StudentProfile;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book 
{
	@Id
	private String name;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
