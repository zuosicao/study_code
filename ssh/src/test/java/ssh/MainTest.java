package ssh;

import java.io.Serializable;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cong.ruan.beans.Student;
import cong.ruan.dao.impl.StudentDaoImpl;

public class MainTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-core.xml");
		
		StudentDaoImpl stuDao = context.getBean(StudentDaoImpl.class,"stuDao");
		
		Student stu = new Student();
		stu.setName("rc");
		stu.setId(null);
		
		Student result = stuDao.saveStudent(stu);
		System.out.println(">>>>>>>>>>>" + result.getId());
	}
}
