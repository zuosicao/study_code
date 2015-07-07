package cong.ruan.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestValidateIntercepter extends ActionSupport
{
	@Override
	public void validate()
	{
		// TODO Auto-generated method stub
		System.out.println("validate.........");
		super.validate();
	}
	
	public String execute()
	{
		System.out.println("execute/.....");
		return "success";
	}
}
