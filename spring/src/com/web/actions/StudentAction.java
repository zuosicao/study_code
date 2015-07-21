package com.web.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.beans.Student;
import com.web.services.interfaces.StudentSerivce;

@Service
public class StudentAction {
	@Autowired
	private StudentSerivce stuService;
	
	public List<Student> getPageStudent(int pageNum) {
		System.out.println("From StudentAction.java >>>>>>>>>>>>" + pageNum);
		return stuService.getPageStudent(pageNum);
	}
}
