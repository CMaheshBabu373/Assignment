package com.test.service;

import javax.validation.constraints.NotBlank;

public class Person {
	@NotBlank(message="Name is required")
	private String name;
	@NotBlank(message="Surname is required")
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
