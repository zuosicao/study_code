package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Curstom;

public class TestHibernateDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
    public Curstom getCurstomById(int curstomId)
    {
    	Session session = sessionFactory.getCurrentSession();
    	
    	Curstom cs = (Curstom)session.get(Curstom.class, curstomId);
    	
    	
    	return cs;
    }
	
	public TestHibernateDao()
	{
		System.out.println("TestHibernateDao �������ļ��ձ����ص�ʱ����Ѿ�����ʼ���ˣ�");
	}
}
