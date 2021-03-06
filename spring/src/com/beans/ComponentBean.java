package com.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
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
	
	@Bean
	@Scope("prototype")
	public Box componentBox()
	{
		Box rtn = new Box();
		rtn.setKind("componentBox");
		return rtn;
		
	}
	
}
