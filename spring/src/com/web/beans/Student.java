package com.web.beans;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6577157904369012750L;

	private int stuId;
	
	//@Min(0)
	//@Max(100)
	private int age;
	
	private String sex;
	
	private int stuNum;
	
	private Student stu;
	
	//@NotNull
	//@Size(min=3,max=20,message="用户名不能为空")
	private String name;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

}
