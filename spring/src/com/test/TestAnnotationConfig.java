package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beans.Box;
import com.beans.ComponentBean;
import com.config.AppConfig;

public class TestAnnotationConfig {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class,ComponentBean.class);
		
		/*MyService myService = context.getBean(MyService.class);
		myService.service1();
		*/
	/*	Curstom curstom = context.getBean(Curstom.class);
		System.out.println(curstom.getMyBox().getKind());*/
		
		/*ComponentBean cb = context.getBean(ComponentBean.class);
		System.out.println(cb.getName());*/
		
		Box componentBox = context.getBean(Box.class);
		Box com2 = context.getBean(Box.class);
		System.out.println(com2 == componentBox);
		System.out.println(componentBox.getKind());
	}
}
