package com.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Curstom {
	
	private int curstomId;
	private String name;
	private String sex;
	private int age;
	
	@Autowired
	private Box myBox;
	
	public int getCurstomId() {
		return curstomId;
	}

	public void setCurstomId(int curstomId) {
		this.curstomId = curstomId;
	}

	public Box getMyBox() {
		return myBox;
	}

	public void setMyBox(Box myBox) {
		this.myBox = myBox;
	}

	public void init()
	{
		System.out.println("this is init method");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void goShoppiing()
	{
		System.out.println("get some things into my cart");
	}
	
	public Curstom()
	{
		System.out.println("Curstom construaction invoked!!");
	}
}
