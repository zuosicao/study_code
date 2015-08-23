package cong.ruan.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("base")
public class BaseDao<T>{
	
	@Resource
    private SessionFactory sessionFactory;
	
	public T save(T t){
		sessionFactory.getCurrentSession().save(t);
		return t;
	}
}
