package ssh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cong.ruan.beanobj.StudentObj;
import cong.ruan.dao.impl.StudentDaoImpl;

public class MainTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-core.xml");
		
		StudentDaoImpl stuDao = context.getBean(StudentDaoImpl.class,"stuDao");
		
		/*Student stu = new Student();
		stu.setName("fuckkkkk");
		stu.setId(null);
		
		Student result = stuDao.save(stu);
		System.out.println(">>>>>>>>>>>" + result.getId());*/
		
		//Pager<Student> stus = stuDao.queryPageStus(-1,3);
		/*Pager<Object> stus = stuDao.pagerListObj(StudentDaoImpl.GET_STUDENTS_NAME, 1, 3);
		for (Object stu : stus.getDatas() ){
			System.out.println(stu);
		}*/
		
		StudentObj stuObj = stuDao.pagerStusNameList(1, 5);
		System.out.println(stuObj.getDatas().get(1).getId());
	}
}
