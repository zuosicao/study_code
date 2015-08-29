package cong.ruan.beans;

public class LoginedUser
{
	private String username;
    private	String password;
	private int userId;
	
	
	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public LoginedUser(int userId,String username,String password)
	{
		this.username = username;
		this.password = password;
		this.userId = userId;
		
	}
	
	public LoginedUser()
	{
		
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
}
