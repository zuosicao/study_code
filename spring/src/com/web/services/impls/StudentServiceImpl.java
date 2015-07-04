package com.web.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.beans.Student;
import com.web.dao.interfaces.StudentDao;
import com.web.services.interfaces.StudentSerivce;

@Service
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
