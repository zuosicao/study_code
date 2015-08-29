package cong.ruan.action;

import cong.ruan.beans.Person;

public class TagText extends MySupport
{
	private String name;
	private Person person;
	
	
	
	public Person getPerson()
	{
		return person;
	}

	public void setPerson(Person person)
	{
		this.person = person;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}



	@Override
	public String execute() throws Exception
	{
		person = new Person("cccccc");
		System.out.println(getText("messages"));
		name="改名";
		return super.execute();
	}
}
