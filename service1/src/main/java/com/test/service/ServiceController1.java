package com.test.service;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ServiceController1 {
	
	@Autowired
	HealthEndpoint healthEndpoint;
	
	@Autowired
	private ServiceClass serviceClass;
	
	@LogBeforeMethod
	@RequestMapping("/status")
	public String getStatus() {
		return healthEndpoint.health().getStatus().toString();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/result")
	@ResponseBody
	@LogBeforeMethod
	public String getconcat(@Valid @RequestBody Person person) {
		return serviceClass.getconcat(person);
	}
	
}
