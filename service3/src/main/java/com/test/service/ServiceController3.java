package com.test.service;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class ServiceController3 {
	
	Logger logger = (Logger) LoggerFactory.getLogger(ServiceController3.class);
	
	@LogBeforeMethod
	@RequestMapping(method = RequestMethod.POST,value="/concat")
	public String concat(@RequestBody Person person) {
		logger.info("Passed JSON - " + "Name : " + person.getName() + "  Surname: " + person.getSurname());
		return (person.getName() + " " + person.getSurname());
	}
	
}
