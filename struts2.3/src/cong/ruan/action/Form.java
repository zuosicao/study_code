package cong.ruan.action;

import java.util.ArrayList;
import java.util.List;

import cong.ruan.beans.Sex;

public class Form
{
	private String username;
	private List<Sex> lists = new ArrayList<Sex>();
	private String[] sex = {"M","F"};
	private char[] test = {'a','b'};
	public static String HAHA = "haha,我是静态变量";

	public char[] getTest()
	{
		return test;
	}

	public void setTest(char[] test)
	{
		this.test = test;
	}

	public String[] getSex()
	{
		return sex;
	}

	public void setSex(String[] sex)
	{
		this.sex = sex;
	}

	public String getUsername()
	{
		return username;
	}

	public List<Sex> getLists()
	{
		return lists;
	}

	public void setLists(List<Sex> lists)
	{
		this.lists = lists;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String execute()
	{
		lists.add(new Sex("M","男"));
		lists.add(new Sex("F","女"));
		username = "ruancong";
		
		return "success";
	}
	
	public static String test()
	{
		return "静态方法";
	}
}
