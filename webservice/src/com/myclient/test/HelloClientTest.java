package com.myclient.test;

import com.myclient.HelloService;
import com.myclient.HelloServiceService;

public class HelloClientTest {
	public static void main(String[] args) {
		HelloService helloService = new HelloServiceService().getHelloServicePort();
		String result = helloService.sayHello("Tom");
		System.out.println(result);
	}
}
