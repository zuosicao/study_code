package cong.ruan.action;

public class Error
{
	public String execute()
	{
		System.out.println("Error.java 这里出现了异常");
		int i  = Integer.parseInt("dd");
		System.out.println(i);
		return "success";
	}
}
