package cong.ruan.action;

import cong.ruan.beans.RegisterBean;

public class ValidateByXmlAction extends MySupport
{
	private RegisterBean userInfo;
	private String name;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RegisterBean getUserInfo()
	{
		return userInfo;
	}

	public void setUserInfo(RegisterBean userInfo)
	{
		this.userInfo = userInfo;
	}
	
	public String execute()
	{
		System.out.println("ddddd");
		System.out.println(userInfo.getUsername());
		return "success";
	}
	
}
