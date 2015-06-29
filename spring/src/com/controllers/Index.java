package com.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	
    @RequestMapping({"/home"})
	public String homePage(Map<String,Object> model) {
    	
    	System.out.println("index request!!");
    	return "home";
	}
    
    public Index()
    {
    	System.out.println("index invoked!");
    }
    
}
