package com.test.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Service3Application {

	@LogBeforeMethod
	public static void main(String[] args) {
		SpringApplication.run(Service3Application.class, args);
	}
}
