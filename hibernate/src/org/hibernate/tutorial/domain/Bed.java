package org.hibernate.tutorial.domain;

import java.io.Serializable;

public class Bed implements Serializable
{
	private String id;
	private String bedName;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getBedName()
	{
		return bedName;
	}
	public void setBedName(String bedName)
	{
		this.bedName = bedName;
	}
}
