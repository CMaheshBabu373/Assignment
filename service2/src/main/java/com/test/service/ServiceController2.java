package com.test.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController2 {
	
	@RequestMapping("/hello")
	@LogBeforeMethod
	public ResponseEntity<String> getdetails() {
//		return new ResponseEntity<String>("Hello",HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body("Hello");
	}
}
