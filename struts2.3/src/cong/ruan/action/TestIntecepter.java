package cong.ruan.action;

public class TestIntecepter
{
	private String username;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String execute()
	{
		System.out.println("execute invoked!!");
		return "success";
	}
}
