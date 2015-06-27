package com.beans;

import org.springframework.stereotype.Component;

@Component
public class ComponentBean {
	private String name = "initName";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
