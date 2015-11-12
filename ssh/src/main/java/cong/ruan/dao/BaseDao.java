package cong.ruan.dao;

import java.util.List;

import cong.ruan.utils.Pager;

/**
 * 
 * @author RuanCong
 * 2015年11月12日 下午1:39:10
 *
 */
public interface BaseDao {
	
	public <T extends Object>T save(T t);
	
	public <T extends Object>void update(T t);
	
	public <T extends Object>void delete(T t);
	
	public <T extends Object>T get(int id,Class<T> clazz);
	
	public <T extends Object>List<T> listAll(String hql,Object[] argrs);
	
	public <T extends Object>Pager<T> pagerList(String hql,Object[] args,int page,int pageSize);

	public <T extends Object>Pager<T> pagerList(String hql,int page,int pageSize);

	public Pager<Object> pagerListObj(String hql,int page,int pageSize);
	
	public Pager<Object> pagerListObj(String hql,Object[] args,int page,int pageSize);

}
