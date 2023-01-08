package com.example.Books_Inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Serve 
{
	

	@Autowired
	private DAO dao;
	
	
	public List <BooksAvailable> getAll()
	{
		return this.dao.findAll();
	}
	
	public void insert(BooksAvailable b)
	{
		this.dao.save(b);
	}

	public BooksAvailable getOne(String s) 
	{
		
		// TODO Auto-generated method stub
		List <BooksAvailable> l1 = this.dao.findAll();
		BooksAvailable c = null;
		for(BooksAvailable b1 : l1)
		{
			if(b1.getName().equalsIgnoreCase(s))
			{
				c = b1;
				break;
			}
		}
		return c;
		
		
	}

	public void updateone(String name, int quantity) {
		// TODO Auto-generated method stub
		
		
		List <BooksAvailable> l1 = this.dao.findAll();
		BooksAvailable c = null;
		for(BooksAvailable b1 : l1)
		{
			if(b1.getName().equalsIgnoreCase(name))
			{
				c = b1;
				break;
			}
		}
		c.setQuantity(quantity);
		this.dao.save(c);
	}
	
	
	
	  public List <BooksAvailable> customMethod(String name, int quantity) 
	  {
		  
		  
			
			  List <BooksAvailable> l1 = this.dao.getAllBooksAvailable(); 
			  l1.forEach(o ->System.out.println(o.toString()));
			  
			  
			  System.out.println("-----------------------------------------------");
			  System.out.println(this.dao.getOne(name));
			  System.out.println("------------------------------------------------");
			  this.dao.natFindAll().forEach(e -> System.out.println(e));
			  System.out.println("-------------------------------------------------");
			 
		  return this.dao.findByNameAndQuantity(name,quantity); 
		  }
	  
		/*
		 * public List <BooksAvailable> getAllBooks() { return this.dao.getAll(); }
		 */
	 
}
