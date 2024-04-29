package com.test.Task;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ParentChild {

	int id;
	Map<Integer,ParentChild> children;
	
	public ParentChild() {	
	}
	public ParentChild(int id) {
		this.id = id;
		this.children = new HashMap<>();
	}
	public ParentChild(int id, Map<Integer, ParentChild> children) {
		super();
		this.id = id;
		this.children = children;
	}
}
