package com.myservices;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class HelloService {

	public String sayHello(String username)
	{
		String result = "";
		if (username != null && !username.trim().equals(""))
		{
			result = username + "，你好！很高兴你用我提供的服务";
		}else
		{
			result = "请输入用户名！！";
		}
		return result;
	}
	
	public static void main(String[] args) {
		//格式：wsimport -s "src目录" -p “生成类所在包名” -keep “wsdl发布地址”
		//wsimport -s D:\development\gitRepositories\study_code\webservice\src -p com.myclient -keep http://localhost:8080/helloService?wsdl
		//访问的时候要加?wsdl8
		Endpoint.publish("http://localhost:8090/helloService", new HelloService());
		System.out.println("启动成功 ！！");
		

	}

}
