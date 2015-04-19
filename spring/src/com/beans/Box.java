package com.beans;

import java.util.List;

public class Box {
	private String color;
	private String kind;
	private List<String> things;

	public List<String> getThings() {
		return things;
	}

	public void setThings(List<String> things) {
		this.things = things;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

}
