package com.beans;

import java.util.List;

public class Society {
	private List<Person> members;
	
	public int getSize() {
		return members.size();
	}

	public List<Person> getMembers() {
		return members;
	}

	public void setMembers(List<Person> members) {
		this.members = members;
	}

	
}
