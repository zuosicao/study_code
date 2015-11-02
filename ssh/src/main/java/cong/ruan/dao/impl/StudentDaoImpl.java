package cong.ruan.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cong.ruan.beans.Student;

@Repository("stuDao")
public class StudentDaoImpl{
	@Resource
    private SessionFactory sessionFactory;
	
	public static String GET_STUDENTS = "from Student";
	public static String GET_STUDENTS_ARGS = "from Student stu where stu.id > ?";
	public static String GET_STUDENTS_NAME = "select stu.name,stu.id from Student stu";
	public static int DEFAULT_PAGE_SIZE = 10;
	
	/*public StudentObj pagerStusNameList(int page,int pageSize){
		Pager<Object> result = pagerListObj(GET_STUDENTS_NAME, page, pageSize);
		StudentObj sObj = new StudentObj();
		List<StudentObj> names = new ArrayList<StudentObj>();
		
		List<Object> objs = result.getDatas();
		for (Object row : objs){
			StudentObj  temp = new StudentObj();
			if (row instanceof Object[]){
				Object[] aRow = (Object[])row;
				String name = (String)aRow[0] ;
				int id = (int)aRow[1];
				temp.setName(name);
				temp.setId(id);
				
				names.add(temp);
			}else{
				String name = (String)row ;
				names.add(name);
			}
		}
		
		sObj.setDatas(names);
		
		return sObj;
	}*/
	//@Transactional
	public void saveStudents(Student[] stus){
		Session session = sessionFactory.getCurrentSession();
		//Transaction tx = session.beginTransaction();
		for (int i=0; i < stus.length; i++){
			if (i == 1){
				throw new RuntimeException();//出运行时错误 才会回滚
			}
			session.save(stus[i]);
			//Thread.sleep(7000);  事务 在这个方法执行完之后再提交的
		}
		
		//tx.commit();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Student aaaqueryStudentById(int id,int threadId){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		System.out.println(threadId + "thread have begin Transaction" );
		Query query = session.createQuery("update Student stu set stu.name = :newName where stu.id = :id");
		query.setInteger("id", id);
		query.setString("newName", threadId + "aaaaaaaaathread");
		System.out.println(threadId);
		//query.setLockMode("stu", LockMode.READ);
		query.executeUpdate();
		if (threadId == 1){
			try {
				System.out.println("1sleep....");
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (threadId == 2){
			try {
				Thread.sleep(10000);
				List l = session.createQuery("From Student stu where stu.id = 1").list();
				Student stu = (Student) l.get(0);
				System.out.println(stu.getName());
				System.out.println("2sleep....");
				Thread.sleep(50000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ts.commit();
		return null;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
