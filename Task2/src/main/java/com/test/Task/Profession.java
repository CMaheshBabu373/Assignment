package com.test.Task;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profession {
	@Id
	private int id;
	private int parentid;
	private String name;
	private String color;
	
	public Profession() {
		
	}
	public Profession(int id, int parentid, String name, String color) {
		super();
		this.id = id;
		this.parentid = parentid;
		this.name = name;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getparentid() {
		return parentid;
	}

	public void setparentid(int parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
