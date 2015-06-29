package com.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.beans.Student;
import com.web.services.StudentSerivce;

@Controller
public class Index {

	@Autowired
	private StudentSerivce stuService;

	@RequestMapping(value = { "/home" })
	public String homePage(HttpServletRequest requset, Map<String, List<Student>> model) {
		String pageParm = requset.getParameter("page");
		int page = 1;
		try {
			page = Integer.parseInt(pageParm);
			if (page < 1)
			{
				page = 1;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		model.put("pageStus", stuService.getPageStudent(page));
		return "home";
	}

	public Index() {
		System.out.println("index invoked!");
	}

}
