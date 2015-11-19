package com.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exceptions.IllegalNumber;
import com.web.actions.TestAction;
import com.web.beans.Student;
import com.web.runnables.TestActionWork;
import com.web.services.interfaces.StudentSerivce;

@Controller
public class Index {

	@Autowired
	private StudentSerivce stuService;
	@Value("#{servletContext.servletContext}")
	private ServletContext sc;
	
	@Autowired
	private TestAction testAction;

	@RequestMapping(value = { "/home" })
	public String homePage(HttpServletRequest requset, Map<String,Object> map) {
		
		/*for (int i = 1; i <= 10; i++)
		{
			TestActionWork taw = new TestActionWork(testAction,i);
			new Thread(taw).start();
		}*/
		
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
		map.put("pageStus", stuService.getPageStudent(page));
		map.put("test","test22");
		System.out.println(sc.getRealPath("/resources"));
		return "home";
	}
	
	@RequestMapping(value="/home/{page}")
	public String getOnePageUsers(@PathVariable("page") String pageNum,Map<String, List<Student>> model)
	{
		int page = 1;
		try
		{
			page = Integer.parseInt(pageNum);
			if (page < 1)
			{
				page = 1;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new IllegalNumber();
		}
		model.put("pageStus", stuService.getPageStudent(page));
		return "home";
	}

	public Index() {
		System.out.println("index invoked!");
	}

}
