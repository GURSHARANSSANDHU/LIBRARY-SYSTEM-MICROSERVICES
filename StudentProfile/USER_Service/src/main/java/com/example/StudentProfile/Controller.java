package com.example.StudentProfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Controller 
{
	
	@Autowired
	private Serve service;
	
	@Autowired
	private RestTemplate rest;
	
	
	@RequestMapping("/read/all")
	public List <StudentProfile> ReadAll()
	{
		System.out.println("REQUEST LANDED IN THE READ ALL FUNCTION");
		return this.service.getAll();
	}
	
	@RequestMapping("/insert/one")
	public void createOne(@RequestBody StudentProfile s)
	{
		System.out.println(s.getStudent_Name());
		this.service.insertOne(s);
	}
	
	@RequestMapping("/update/add/{rollno}")
	public void updateAdd(@PathVariable int rollno, @RequestBody Book b1)
	{
	
		System.out.println("request landed");
	    Inventory s = this.rest.getForObject("http://books-inventory/Inventory/get/one/" + b1.getName(), Inventory.class);
	    System.out.println("AFTER CALL");
		System.out.println(s);
		if(s == null)
		{
			System.out.println("THE BOOK IS NOT PRESENT ON THE REPOSITORY");
			
		}
		else
		{
			if(s.getQuantity() > 0)
			{
			this.service.updateAdd(rollno, b1);
			}
			else
			{
				System.out.println("the stocks are exhausted");
			}
	
		}
		int quantity = s.getQuantity() - 1;
		rest.put("http://books-inventory/Inventory/update/quantity/" + b1.getName() + "/" + quantity,b1);
		
		
		
	}
	
	
	@RequestMapping("/read/one/{rollno}")
	public StudentProfile readOne(@PathVariable int rollno)
	{
		return this.service.readOne(rollno);
	}
	
	
	@RequestMapping("/update/sub/{rollno}")
	public void updateSub(@PathVariable int rollno, @RequestBody Book b1)
	{
		int flag = this.service.updateSub(rollno, b1);
		
		if(flag == 1)
		{
			Inventory i = this.rest.getForObject("http://localhost:7003/Inventory/get/one/" + b1.getName(), Inventory.class);
		int q = i.getQuantity() + 1;
		this.rest.put("http://localhost:7003/Inventory/update/quantity/" + b1.getName() + "/" +  q , b1);
		}
	}
	
	
	
	
	
	

}
