package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.beans.Student;
import com.web.dao.StudentDao;

public class StudentServiceImpl implements StudentSerivce {

	@Autowired
	private StudentDao stuDao;
	
	@Override
	public List<Student> getPageStudent(int pageNum) {
		return stuDao.getPageStudent(pageNum);
	}

	
	/*public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/configs/services.xml");
		StudentSerivce stuDao = context.getBean("stuService",StudentSerivce.class);
		System.out.println(stuDao.getPageStudent(1).get(0).getName());
	}*/
}
