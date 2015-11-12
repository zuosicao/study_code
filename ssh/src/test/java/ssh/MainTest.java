package ssh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cong.ruan.beans.Student;
import cong.ruan.dao.impl.StudentDaoImpl;
import cong.ruan.services.StudentService;

public class MainTest {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-core.xml");
		
		StudentDaoImpl stuDao = context.getBean(StudentDaoImpl.class,"stuDao");
		StudentService stuService = context.getBean(StudentService.class);
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
		
		/*StudentObj stuObj = stuDao.pagerStusNameList(1, 5);
		System.out.println(stuObj.getDatas().get(1).getId());*/
		
		/*Student s1 = new Student();
		s1.setName("sss111");
		Student s2 = new Student();
		s2.setName("sss222");
		
		stuDao.saveStudents(new Student[]{s1,s2});*/


		/*new Thread(new Runnable() {
			
			@Override
			public void run() {
					System.out.println("from 1");
					
				stuDao.aaaqueryStudentById(1,1);
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("from 2");
				stuDao.aaaqueryStudentById(1,2);
			}
		}).start();*/
		
		/*Student s1 = new Student();
		s1.setName("sss111");
		s1.setMoney(23.2);
		stuService.saveStudent(s1);*/
		
		/*Student s1 = new Student();
		s1.setName("sss111");
		s1.setMoney(23.2);
		
		Student s2 = new Student();
		s2.setName("sss222");
		s2.setMoney(33.3);
		
		Student s3 = new Student();
		s3.setName("sss333");
		s3.setMoney(43.2);
		
		stuService.saveAllStudentsOrNone(new Student[]{s1,s2,s3});*/
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				stuService.reduceMoney(29,5.0);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				stuService.reduceMoney(29,7.0);
			}
		}).start();
		
	}
}
