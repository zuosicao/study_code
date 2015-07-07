package cong.ruan.action;

import com.opensymphony.xwork2.ActionSupport;

public class Validate extends ActionSupport
{
	private String username;
	private String password;
	
	@Override
	public void validate()
	{
		if ("".equals(username) || username == null)
		{
			this.addFieldError("nameError","姓名不能为空");
			this.addFieldError("nameError","姓名不能为空2");
		}
		if ("".equals(password) || password == null)
		{
			this.addFieldError("passwordError","密码不能为空");
		}
	}
	
	@Override
	public String execute()
	{
		return "success";
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
