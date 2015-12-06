package cong.ruan.dao;

import java.util.List;
import java.util.Map;

import cong.ruan.utils.Pager;

public interface BaseDao {
	
	public <T extends Object>T save(T t);
	
	public <T extends Object>void update(T t);
	
	public <T extends Object>void delete(T t);
	public <T extends Object>T deleteById(int id,Class<T> clazz);
	
	public <T extends Object>T load(int id,Class<T> clazz);
	
	/**
	 * 得到实体类 否则返回null
	 * @param id
	 * @param clazz 实体类class
	 * @return
	 */
	public <T extends Object>T get(int id,Class<T> clazz);
	
	/**
	 * 得到实体类 否则返回null
	 * @param hql
	 * @param agrs hql中的参数
	 * @return
	 */
	public <T extends Object>T getObjectByHql(String hql,Object[] agrs);
	
	/**
	 * 用sql语句查询一条数据，将查询结果映射到aliasToBeanClazz
	 * @param sql  sql中字段的别名与aliasToBeanClazz类中的属性名一样
	 * @param args  sql中的参数
	 * @param aliasToBeanClazz  需要被映射到的类的class
	 * @return
	 */
	public <T extends Object>T getObjectBySql(String sql,Object[] args,Class<T> aliasToBeanClazz);
	
	/**
	 * 根据hql语句得到所有的记录
	 * @param hql
	 * @param argrs hql中的参数
	 * @return
	 */
	public <T extends Object>List<T> listAllByHql(String hql,Object[] argrs);
	
	/**
	 * 根据hql语句得到所有的记录
	 * @param hql
	 * @return
	 */
	public <T extends Object>List<T> listAllByHql(String hql);

	/**
	 * 
	 * @param hql
	 * @param params 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public <T extends Object>Pager<T> pagerListWithParamsByHql(String hql,Map<String,Object> params,int page,int pageSize);
	
	public <T extends Object>Pager<T> pagerListByHql(String hql,Object[] args,int page,int pageSize);

	public <T extends Object>Pager<T> pagerListByHql(String hql,int page,int pageSize);
	
	public <T extends Object>Pager<T> pagerListObjToEntityByHql(String sql,Object[] args,Class<T> aliasToBeanClazz,int page,int pageSize);

	public Pager<Object> pagerListObjByHql(String hql,int page,int pageSize);
	
	public Pager<Object> pagerListObjByHql(String hql,Object[] args,int page,int pageSize);

	/**
	 * 根据sql语句分页查询结果,并且将结果hql的字段映射到aliasToBeanClazz类(实体中)的属性中
	 * @param sql  sql中字段的别名与aliasToBeanClazz类中的属性名一样
	 * @param args sql中的参数
	 * @param aliasToBeanClazz 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public <T extends Object>Pager<T> pagerListObjToEntityBySql(String sql,Object[] args,Class<T> aliasToBeanClazz,int page,int pageSize);
	/**
	 * 根据sql语句分页查询结果,并且将结果hql的字段映射到aliasToBeanClazz类(实体中)的属性中
	 * @param sql  sql中字段的别名与aliasToBeanClazz类中的属性名一样
	 * @param args sql中的参数
	 * @param aliasToBeanClazz 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public <T extends Object>Pager<T> pagerListObjToEntityBySql(String sql,Class<T> aliasToBeanClazz,int page,int pageSize);

	/**
	 * 根据sql查询所有的记录,并且将sql的字段映射到aliasToBeanClazz类中
	 * @param sql sql中字段的别名与aliasToBeanClazz类中的属性名一样
	 * @param args sql中的参数
	 * @param aliasToBeanClazz
	 * @return
	 */
	public <T extends Object>List<T> listAllToEntityBySql(String sql,Object[] args,Class<T> aliasToBeanClazz);

	/**
	 * 执行sql
	 * @param sql
	 * @param args
	 */
	public void executeSql(String sql,Object[] args);
}
