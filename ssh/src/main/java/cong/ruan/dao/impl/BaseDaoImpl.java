package cong.ruan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cong.ruan.dao.BaseDao;
import cong.ruan.utils.Pager;
@SuppressWarnings("unchecked")
@Repository("base")
public class BaseDaoImpl implements BaseDao{
	
	@Resource
    private SessionFactory sessionFactory;
	
	public <T extends Object>T save(T t){
		sessionFactory.getCurrentSession().save(t);
		return t;
	}
	
	@Override
	public <T extends Object>Pager<T> pagerList(String hql,Object[] args,int page,int pageSize){
		Pager<T> result = new Pager<T>();
		
		Session session = sessionFactory.getCurrentSession();
		
		String countHql = generateCountHQL(hql);
		Query countQuery = session.createQuery(countHql);
		setQueryParms(countQuery, args);
		Long count = (Long)countQuery.uniqueResult();
		
		if (count > 0){
			
			Query query = session.createQuery(hql);
			// TODO page < 1   hql的参数与object数组大小不符合
			int setoff = (page-1) * pageSize;
			int maxResults = pageSize;
			setQueryParms(query, args);
			
		
			List<T> datas = query.setFirstResult(setoff).setMaxResults(maxResults).list();
			
			result.setDatas(datas);
			result.setCurrentPage(page);
			result.setPageSize(pageSize);
			int total = count.intValue();
			result.setTotal(total);
		}else{
			result.setTotal(0);
			result.setCurrentPage(page);
			result.setDatas(new ArrayList<T>());
		}
		return result;
	}
	
	@Override
	public <T extends Object>Pager<T> pagerList(String hql,int page,int pageSize){
		return pagerList(hql, null, page, pageSize);
	}
	
	@Override
	public Pager<Object> pagerListObj(String hql,Object[] args,int page,int pageSize){
		Pager<Object> result = new Pager<Object>();
		
		Session session = sessionFactory.getCurrentSession();
		
		String countHql = generateCountHQL(hql);
		Query countQuery = session.createQuery(countHql);
		setQueryParms(countQuery, args);
		Long count = (Long)countQuery.uniqueResult();
		
		if (count > 0){
			
			Query query = session.createQuery(hql);
			// TODO page < 1   hql的参数与object数组大小不符合
			int setoff = (page-1) * pageSize;
			int maxResults = pageSize;
			setQueryParms(query, args);
		
			List<Object> datas = query.setFirstResult(setoff).setMaxResults(maxResults).list();
			
			result.setDatas(datas);
			result.setCurrentPage(page);
			result.setPageSize(pageSize);
			int total = count.intValue();
			result.setTotal(total);
		}else{
			result.setTotal(0);
			result.setCurrentPage(page);
			result.setDatas(new ArrayList<Object>());
		}
		return result;
	}
	
	@Override
	public Pager<Object> pagerListObj(String hql,int page,int pageSize){
		return pagerListObj(hql,null, page, pageSize);
	}
	
	/**
	 * 设置query的参数
	 * @param query
	 * @param args
	 */
	private void setQueryParms(Query query,Object[] args){
		if (args == null || args.length == 0){
			return;
		}
		for (int i = 0; i < args.length; i++){
			query.setParameter(i, args[i]);
		}
	}
	
	/**
	 * 根据hql语句生成查询总数量的sql语句
	 * @return
	 */
	private String generateCountHQL(String hql){
		int index = hql.indexOf("from");
		String countSQL = "select count(*) " + hql.substring(index);
		System.out.println("From BaseDao.java" + countSQL);
		return countSQL;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public <T> void update(T t) {
		 sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public <T> void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> T get(int id, Class<T> clazz) {
		return (T)sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public <T> List<T> listAll(String hql, Object[] argrs) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
