package com.example.Books_Inventory;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class BooksAvailable 
{
    @Id
    private String name;
    private int price;
    private int quantity;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "BooksAvailable [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
