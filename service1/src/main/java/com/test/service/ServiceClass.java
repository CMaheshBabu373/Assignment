package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceClass {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@LogBeforeMethod
	public String getconcat(Person person) {
		String response1 = restTemplate.getForObject("http://ec2-15-206-91-219.ap-south-1.compute.amazonaws.com:8082/hello", String.class);
		
		String response2 = restTemplate.postForObject("http://ec2-43-205-231-0.ap-south-1.compute.amazonaws.com:8083/concat", person, String.class);
		
		return response1 + " " + response2;
	}
	
}
