package com.example.Books_Inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Inventory")
public class Controller 
{
	
	
	@Autowired
	private Serve service;
	
	
	@Value("${server.port}")
	private String port;
	
	
	@RequestMapping("/read/all")
	public List <BooksAvailable> readAll()
	{
       
		return this.service.getAll();
	}
	
	@RequestMapping("/insert/one")
	public void create(@RequestBody BooksAvailable b)
	{
		this.service.insert(b);
	}
	
	@RequestMapping("/get/one/{name}")
	public BooksAvailable readOne(@PathVariable String name)
	{
		 System.out.println("the request is being hitted at the instance running at port:" + this.port);
		return this.service.getOne(name);
	}
	
	@RequestMapping("/update/quantity/{name}/{quantity}")
	public void updateQuantity(@PathVariable String name, @PathVariable int quantity, @RequestBody BooksAvailable b1)
	{
		this.service.updateone(name,quantity);
	}
	
	
	  @RequestMapping("/Custom/{name}/{quantity}") 
	  public List<BooksAvailable> customized(@PathVariable String name, @PathVariable int quantity) 
	  { return
	  this.service.customMethod(name,quantity); }
	  
	  
	  @RequestMapping("/retrive/port")
	  public String portNo()
	  {
		  return this.port;
	  }
	 

}
