package cong.ruan.beans;

import java.io.Serializable;

public class User implements Serializable
{
	private int userId;
	private String username;
	
	
	
	public User()
	{
		
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}

}
