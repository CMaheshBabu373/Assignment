package com.test.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;

public class Person {
	@NotBlank
	@NotNull
	private String name;
	@NotBlank
	@NotNull
	private String surname;
	
	public Person() {
		
	}

	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	

}
