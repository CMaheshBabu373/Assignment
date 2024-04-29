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
		String response1 = restTemplate.getForObject("http://ec2-13-234-32-188.ap-south-1.compute.amazonaws.com:8080/hello", String.class);
		
		String response2 = restTemplate.postForObject("http://ec2-3-111-218-147.ap-south-1.compute.amazonaws.com:8080/concat", person, String.class);
		
		return response1 + " " + response2;
	}
	
}
