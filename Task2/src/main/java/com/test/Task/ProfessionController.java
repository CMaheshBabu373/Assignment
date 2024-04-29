package com.test.Task;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@RestController
public class ProfessionController {
	
	@Autowired
	private ProfessionService professionService;
	
	
	@RequestMapping("/details")
	public List<Profession> getAllDetails() {
		return professionService.getAllDetails();
	}
	
	@LogMethodParam
	@RequestMapping("/details/{id}")
	public Profession getdetails(@PathVariable int id) {
		return professionService.getdetails(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/details")
	public void addRow(@RequestBody Profession profession) {
		professionService.addRow(profession);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value="/details/{id}")
	public void updateRow(@RequestBody Profession profession, @PathVariable int id) {
		professionService.updateRow(profession, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/details/{id}")
	public void deleteRow(@PathVariable int id) {
		professionService.deleteRow(id);
	}
	
	@RequestMapping("/result")
	@JsonInclude(Include.NON_NULL)
	public List<Model> getdetail() {
		return professionService.getdetail();
	}

	
}
