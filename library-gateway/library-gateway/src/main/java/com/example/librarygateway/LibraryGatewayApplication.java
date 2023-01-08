package com.example.librarygateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
public class LibraryGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryGatewayApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
