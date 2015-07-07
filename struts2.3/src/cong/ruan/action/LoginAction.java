package cong.ruan.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cong.ruan.beans.LoginedUser;

public class LoginAction
{
	private LoginedUser user;

	public LoginedUser getUser()
	{
		return user;
	}

	public void setUser(LoginedUser user)
	{
		this.user = user;
	}
	
	public String execute()
	{
		if("1308811723@qq.com".equals(user.getUsername()) && "ruancong130".equals(user.getPassword()))
		{
			ActionContext.getContext().getSession().put("user",user);
			return "success";
		}
		Map<String,Object> map = (Map<String,Object>)ActionContext.getContext().get("request");
		map.put("error","请输入正确的用户名和密码");
		map.put("username",user.getUsername());
		return "fail";
	}
}
