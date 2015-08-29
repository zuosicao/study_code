package cong.ruan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cong.ruan.beanobj.StudentObj;
import cong.ruan.beans.Student;
import cong.ruan.utils.Pager;

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
	
	public void saveStudents(Student[] stus){
		Session session = sessionFactory.getCurrentSession();
		try{
		Transaction tx = session.beginTransaction();
		for (int i=0; i < stus.length; i++){
			if (i == 1){
				throw new Exception();
			}
			session.save(stus[i]);
		}
		
		tx.commit();
		}catch(Exception ex){
			
		}finally{
			if (session.isOpen()){
				System.out.println("Open>>>>>>>>");
				//session.close();
			}
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
