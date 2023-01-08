package com.example.librarygateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/Gateway")
public class GatewayController 
{
	
	@Autowired
	private RestTemplate template;
  
	
	@HystrixCommand(fallbackMethod = "errorOccured")
	@RequestMapping("/read/all/{name}")
	public String getAll(@PathVariable String name)
	{
		BooksAvailable b = template.getForObject("http://books-inventory/Inventory/get/one/" + name, BooksAvailable.class);
		return b.getName()+"  "+b.getPrice()+" "+b.getQuantity();
	}
	
	
	  @RequestMapping("/port")
	  public String getPort()
	  {
		  return this.template.getForObject("http://books-inventory/Inventory/retrive/port", String.class);
	  }
	 
    
	
	public String errorOccured(String name)
	{
		return "Sorry, Books inventory service is down :(";
	}
}
