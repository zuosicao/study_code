package cong.ruan.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cong.ruan.beanobj.StudentObj;
import cong.ruan.services.StudentService;

@Controller
public class StudentController {

	@Resource
	private StudentService stuService;

	@RequestMapping("student")
	public @ResponseBody StudentObj getStudent(String name) {
		StudentObj stuObj = stuService.getOneStudentByName(name);
		return stuObj;
	}
	
	@RequestMapping("pageStu")
	public @ResponseBody StudentObj pageStudent(Integer page,Integer pageSize) {
		StudentObj stuObj = stuService.getPageStudent(page, pageSize);
		return stuObj;
	}
	
	@RequestMapping("allStu")
	public @ResponseBody List<StudentObj> allStudent() {
		List<StudentObj> stuObjs = stuService.getAllStudents();
		return stuObjs;
	}
	
	

}
