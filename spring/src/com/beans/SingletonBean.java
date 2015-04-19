package com.beans;

public class SingletonBean {
	private static SingletonBean sb = new SingletonBean();

	private SingletonBean() {
	}

	public static SingletonBean getInstance() {
		return sb;
	}
	
	public String getClassInfo()
	{
		return sb.getClass().toString();
	}
}
