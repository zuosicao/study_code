package org.hibernate.tutorial.test;


import java.io.Serializable;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.tutorial.domain.Event;
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
		
	/*	Person person = new Person();
		person.setAge(23);
		person.setFirstname("Tom");
		person.setLastname("Cat");
		
		System.out.println(savePerson(person));*/
		
		
		Set<Event> set = getPersonById(1l).getEvents();
		for (Event e : set)
		{
			System.out.println(e.getTitle());
		}
	}
	
	public static Serializable savePerson(Person person)
	{
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		
	
		Transaction tx = session.beginTransaction();
		Serializable result = session.save(person);
		tx.commit();
		
		return result;
	}
	
	public static Person getPersonById(long id)
	{
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session session = sFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		return (Person)session.get(Person.class, id);
	}
}
