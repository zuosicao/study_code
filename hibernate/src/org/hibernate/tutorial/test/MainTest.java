package org.hibernate.tutorial.test;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.tutorial.dao.BaseDao;
import org.hibernate.tutorial.domain.Curstom;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Mg_article;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

public class MainTest {
	public static void main(String[] args) {
		/*SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		
		Bed bed = new Bed();
		bed.setId("bed1");
		bed.setBedName("My Bed2");
		
		Transaction tx = session.beginTransaction();
		
		session.save(bed);
		 
		tx.commit();*/
		
		/*Person person = new Person();
		person.setAge(23);
		person.setFirstname("Tom3");
		person.setLastname("Cat3");
		
		System.out.println(savePerson(person));*/
		
		
		/*Set<Event> set = getPersonById(1l).getEvents();
		for (Event e : set)
		{
			System.out.println(e.getTitle());
		}*/
		
		/*List<Person> persons = getAllPersonByName("Tom");
		for (Person p : persons)
		{
			System.out.println(p.getFirstname());
		}*/
		
	/*	List<Person> persons = getAllPerson();
		for (Person p : persons)
		{
			System.out.println(p.getFirstname());
		}*/
		
		//deleteCurstom();
		
		//initDataSource();
		deleteArticle();
	}
	
	public static void initDataSource()
	{
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
	
		Transaction tx = session.beginTransaction();
		tx.commit();
	}
	
	public static void deleteCurstom()
	{
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		
	
		Transaction tx = session.beginTransaction();
		//session.load(Curstom.class, 1);
		session.delete(session.load(Curstom.class, 1));
		tx.commit();
	}
	
	public static void deleteArticle()
	{
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		
	
		Transaction tx = session.beginTransaction();
		//session.load(Curstom.class, 1);
		session.delete(session.load(Mg_article.class, 1));
		tx.commit();
	}
	
	
	public static Serializable savePerson(Person person)
	{
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		
	
		Transaction tx = session.beginTransaction();
		Serializable result = session.save(person);
		tx.commit();
		if(session.isOpen())
		session.close();
		return result;
	}
	
	public static Person getPersonById(long id)
	{
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Person result = (Person)session.get(Person.class, id);
		
		tx.commit();
		if(session.isOpen())
		session.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Person> getAllPersonByName(String name)
	{
		List<Person> result = null;
		
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		//要用getCurrentSession生产的session，就必须有事务环境，意思就是你必须在调用session的方法之前，session.beginTransaction（）；
		Session session = sFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		result = session.createQuery("from Person where firstname = :firstname")
				.setString("firstname", name).list();
		
		tx.commit();
		//做Query.list()时，并且开启了事物，session会在commit()中就被关闭
		
		if (session.isOpen())
		{
			session.close();
		}
		System.out.println(result.size());
		return result;
	}
	
	public static List<Person> getAllPerson()
	{
		/*List<Person> result = null;
		
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		result = session.createQuery("from Person").list();
		
		tx.commit();
		//做Query.list()时，并且开启了事物，session会在commit()中就被关闭
		if (session.isOpen())
		{
			session.close();
		}
		System.out.println(result.size());
		return result;*/
		
		BaseDao<Person> bd = new BaseDao<Person>();
		return bd.list("from Person", null);
	}
	
}
