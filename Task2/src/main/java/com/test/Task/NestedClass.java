package com.test.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NestedClass {
		
		@Autowired
		ProfessionRepository professionRepository;
		
		public List<Relation> addRelations(){
			List<Profession> p = new ArrayList<Profession>();
			professionRepository.findAll().forEach(p::add);
			List<Relation> relations = new ArrayList<Relation>();
			for(int i=0;i<p.size();i++) {
				relations.add(new Relation(p.get(i).getparentid(),p.get(i).getId()));
			}
			return relations;
		}
		
		public Map<Integer,ParentChild> formRelationship(List<Relation> relations){
			Map<Integer,ParentChild> parentChildMap = new HashMap<Integer, ParentChild>();
			
			for(Relation relation: relations) {
				int parentId = relation.parent;
				int childId = relation.child;
				parentChildMap.putIfAbsent(parentId, new ParentChild(parentId));
				parentChildMap.putIfAbsent(childId, new ParentChild(childId));
			}
			for(Relation relation: relations) {
				int parentId = relation.parent;
				int childId = relation.child;
				ParentChild parent = parentChildMap.get(parentId);
				ParentChild child = parentChildMap.get(childId);
				
				parent.children.put(childId, child);
			}
			return parentChildMap;
		}
		
		public List<Model> displayRelationships(Map<Integer, ParentChild> parentChildMap,List<Model> model) {
				List<Profession> p = new ArrayList<Profession>();
				professionRepository.findAll().forEach(p::add);
				int visited[] = new int[p.size()];
				Arrays.fill(visited,0);
		        for (Map.Entry<Integer, ParentChild> entry : parentChildMap.entrySet()) {
		            int parentId = entry.getKey();
		            if(parentId == 0 || visited[parentId-1]==1) {
		            	continue;
		            }
		            visited[parentId-1] = 1;
		            Model m = new Model(p.get(parentId-1).getName());
		            ParentChild parent = entry.getValue();
		            display(parent.children,visited,m,p);
		            model.add(m);
		        }
		        return model;
		    }
			
		    // Recursive traversal
		    public void display(Map<Integer, ParentChild> children, int[] visited,Model m,List<Profession> p) {
		    	for (Map.Entry<Integer, ParentChild> entry : children.entrySet()) {	
		            ParentChild child = entry.getValue();
		            if(visited[child.id-1]==1) {
		            	continue;
		            }
		            visited[child.id-1]=1;
		        	Model m1 = new Model(p.get(child.id-1).getName());
		            display(child.children,visited,m1,p);
		            
		            if(m1.getSubclasses().isEmpty()) {
		            	m1.setSubclasses(null);
		            }
		            m.addSubclasses(m1);
		        }
		    }	
		
		//Using DFS for the output
//	    public void display(Map<Integer, ParentChild> children, int[] visited,Model m,List<Profession> p) {
//	    	Stack<Integer> stack = new Stack<>();
//			for (Map.Entry<Integer, ParentChild> entry : children.entrySet()) {
//	            ParentChild child = entry.getValue();
//	            if(visited[child.id-1]==1) {
//	            	continue;
//	            }
//	            visited[child.id-1]=1;
//	        	Model m1 = new Model(p.get(child.id-1).getName());
//	        	stack.push(child.id);
//	        	while (!stack.isEmpty()) {
//	                Integer currentId = stack.pop();
//	                ParentChild currentChild = children.get(currentId);
//	                if (currentChild != null) {
//	                    for (Map.Entry<Integer, ParentChild> childEntry : currentChild.children.entrySet()) {
//	                        Integer childId = childEntry.getKey();
//	                        ParentChild nextChild = childEntry.getValue();
//	                        if (visited[childId - 1] == 0) {
//	                            visited[childId - 1] = 1;
//	                            Model subModel = new Model(p.get(childId - 1).getName());
//	                            m1.addSubclasses(subModel);
//	                            stack.push(childId);
//	                        }
//	                    }
//	                }
//	            }
//	          
//	            if(m1.getSubclasses().isEmpty()) {
//	            	m1.setSubclasses(null);
//	            }
//	            m.addSubclasses(m1);
//	        }
//	    }
}
