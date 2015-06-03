package org.hibernate.tutorial.domain;

import java.util.HashSet;
import java.util.Set;


public class Person {

    private Long id;
    private int age;
    private String firstname;
    private String lastname;
    private Set<Event> events = new HashSet<Event>();
    private Set<String> emails = new HashSet<String>();

    public Set<String> getEmails()
	{
		return emails;
	}

	public void setEmails(Set<String> emails)
	{
		this.emails = emails;
	}

	public Person() {}

	public Long getId()
	{
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id)
	{
		this.id = id;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	 

	    public Set<Event> getEvents() {
	        return events;
	    }

	    public void setEvents(Set<Event> events) {
	        this.events = events;
	    }

}