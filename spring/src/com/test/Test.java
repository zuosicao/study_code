package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Curstom;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"xmlbeans.xml","annotationbeans.xml"});
		Curstom cs = context.getBean("curstom",Curstom.class);
		System.out.println(cs.getMyBox().getThings().size());
	 
		/*CurstomProxy cp = context.getBean("proxyCurstom",CurstomProxy.class);
		cp.goShoppiing();
		
		Bean1 bean1 = context.getBean(Bean1.class);
		System.out.println(bean1);
	
		
		SingletonBean sb = context.getBean(SingletonBean.class);
		System.out.println(sb.getClassInfo());*/
		//Test test = context.getBean("test",Test.class);
		//test.fun();
		//test.funArgs("son of a bitch!!");
		
		/*AbstractBean abBean = context.getBean("abBean",AbstractBean.class);
		System.out.println(abBean.fun() == abBean.fun());
		
		Box b1= context.getBean("b1",Box.class);
		Box b2= context.getBean("b1",Box.class);
	System.out.println(b1==b2);*/
		
		//TestDao testDao = context.getBean("testDao",TestDao.class);
		/*Curstom cs = testDao.getCurstomById(1);
		System.out.println(cs.getName());*/
		
		//System.out.println(testDao.getAllCurstoms().size());
		
		/*TestHibernateDao hibernateDao = context.getBean("hibernateDao",TestHibernateDao.class);
		Curstom cs = hibernateDao.getCurstomById(1);
		System.out.println(cs.getName());*/
	}
	
	public void fun()
	{
		System.out.println("I'm from Test fun()");
	}
	
	public void funArgs(String things)
	{
		System.out.println("Test.class" + things);
	}
}
