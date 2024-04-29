package com.test.Task;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Model {
	
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Sub Classes")
    private List<Model> subclasses;
    
    public Model() {	
    }
    
    public Model(String name) {
		this.name = name;
		this.subclasses = new ArrayList<Model>();
	}
	
	public Model(String name, List<Model> subclasses) {
		super();
		this.name = name;
		this.subclasses = subclasses;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Model> getSubclasses() {
		return subclasses;
	}
	
	public void setSubclasses(List<Model> subclasses) {
		this.subclasses = subclasses;
	}
	
	public void addSubclasses(Model subclasses) {
		this.subclasses.add(subclasses);
	}
	
}
