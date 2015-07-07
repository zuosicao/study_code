package cong.ruan.action;

public class Login
{
	private String username;
	private String password;
	
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
	public void setPassword(String passwrod)
	{
		this.password = passwrod;
	}
	
	public String execute()
	{
		System.out.println("true");
		if ("123".equals(username) && "123".equals(password))
		{
			return "success";
		}
		return "login";
	}
	
	
}
