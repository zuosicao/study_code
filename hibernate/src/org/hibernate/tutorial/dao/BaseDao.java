package org.hibernate.tutorial.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;

public class BaseDao<T>{
	
	private Session currentSession()
	{
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> list(String hql,Object[] args)
	{
		currentSession().beginTransaction();
		
		List<T> result = currentSession().createQuery(hql).list();
		currentSession().getTransaction().commit();
		return result;
		
	}
	
	
	
	
}
