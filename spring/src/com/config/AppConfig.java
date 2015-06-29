package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.beans.Box;
import com.beans.Curstom;
import com.services.impls.MyServiceImpl;
import com.services.interfaces.MyService;

@Configuration
public class AppConfig {
   
	@Bean
	public MyService myService()
    {
    	return new MyServiceImpl();
    }
	
/*	@Bean
	public Box myBox()
	{
		Box myBox = new Box();
		myBox.setColor("red");
		myBox.setKind("kind1");
		return myBox;
	}*/
	
	@Bean
	public Curstom myCurstom()
	{
		return new Curstom();
	}
}
