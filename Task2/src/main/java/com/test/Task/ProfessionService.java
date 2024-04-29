package com.test.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionService {
	
	@Autowired
	private ProfessionRepository professionRepository;
	
	@Autowired
	private NestedClass nestedClass;

	public List<Profession> getAllDetails() {
		List<Profession> prof = new ArrayList<>();
		professionRepository.findAll().forEach(prof::add);
		return prof;
	}
	
	public Profession getdetails(int id) {

		List<Profession> prof = new ArrayList<>();
		Profession p = new Profession();
		professionRepository.findAll().forEach(prof::add);
		for(Profession a : prof) {
			if(a.getId() == id) {
				return a;
			}
		}
		return p;
	}
	
	public void addRow(Profession profession) {
		professionRepository.save(profession);
	}
	
	public void updateRow(Profession profession, int id) {
		professionRepository.save(profession);
	}
	
	public void deleteRow( int id) {
		professionRepository.deleteById(id);;
	}
	
	public List<Model> getdetail() {
		List<Model> model = new ArrayList();
		List<Relation> relation = nestedClass.addRelations();
		Map<Integer,ParentChild> parentChildMap = nestedClass.formRelationship(relation);
		return nestedClass.displayRelationships(parentChildMap,model);
	}

}
