package cong.ruan.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cong.ruan.beans.Person;

public class TagTest
{
	private String name;
	private String sex;
	private List<String> list = new ArrayList<String>();
	private List<Person> persons = new ArrayList<Person>();
	
	public List<String> getList()
	{
		return list;
	}
	public void setList(List<String> list)
	{
		this.list = list;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public List<Person> getPersons()
	{
		return persons;
	}
	public void setPersons(List<Person> persons)
	{
		this.persons = persons;
	}
	
	public String execute()
	{
		for (int i = 1; i < 10; i++)
		{
			persons.add(new Person("c" + i));
			list.add("String" + i);
		}
		Map<String,String> requestMap = (Map<String,String>)ActionContext.getContext().get("request");
		requestMap.put("req","请求属性");
		ActionContext.getContext().getSession().put("se","会话");
		name = "ruancong";
		sex = "M";
		return "success";
	}
}
