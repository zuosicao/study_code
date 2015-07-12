package com.web.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.services.interfaces.MyService;
import com.utils.FileUtil;
import com.web.beans.MyServletContext;
import com.web.beans.Student;
import com.web.services.interfaces.StudentSerivce;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	/*@InitBinder  //可以通过这种方式来验证输入  
	protected void initBinder(WebDataBinder webBinder){
		webBinder.setValidator(new StudentValidator());
	}*/
	
	@Autowired
	private StudentSerivce stuService;
	
	@Autowired
	private MyServletContext mySc;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showRegister(Model model)
	{
		Student stu = new Student();
		model.addAttribute(stu);
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String handleRegister(@Valid Student stu,BindingResult br,
								@RequestParam(value="image",required=true)MultipartFile file)
	{
		
		
		if (br.hasErrors())
		{
			System.out.println(br.hasErrors());
			System.out.println(br.getFieldErrors().size());
			return "register";
		}
		
		if (!validateImage(file))
		{
			return "register";
		}
		
		String target = mySc.getServletContext().getRealPath("/resources/") + "33.jpg";
		try {
			FileUtil.saveImage(file.getBytes(), target);
		} catch (IOException e) {
			e.printStackTrace();
			return "register";
		}
		
		System.out.println(stu.getName());
		stuService.addStudent(stu);
		return "redirect:/home";
	}
	
	private boolean validateImage(MultipartFile file)
	{
		return file.getContentType().equals("image/jpeg");
	}
	
}
