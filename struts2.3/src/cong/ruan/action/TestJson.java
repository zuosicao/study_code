package cong.ruan.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestJson extends ActionSupport
{
	private String name;
	private int age;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String execute()
	{
		name = "ruancong";
		age = 22;
		return SUCCESS;
	}
}
