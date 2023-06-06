package com.hystrixDemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class controllers {
	
	@Autowired
	RestTemplate rest;
	
	@HystrixCommand(fallbackMethod = "myfallBack", commandKey = "demoKey")
	@GetMapping("/hello")
	public String greet() {
		return rest.getForObject("http://localhost:8080/hello", String.class);
	}
	
	@HystrixCommand(fallbackMethod = "myfallBack", commandKey = "myCommadKey")
	@GetMapping("/hello1")
	public String greet1() {
		return rest.getForObject("http://localhost:8080/hello", String.class);
	}
	
	public String myfallBack() {
		return "<h1>Sorry User MicroService is down pleace re-try after some time..!!</h1>";
	}

}
