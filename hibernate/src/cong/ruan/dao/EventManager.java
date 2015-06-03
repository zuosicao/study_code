package cong.ruan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

public class EventManager {

    public static void main(String[] args) {
        EventManager mgr = new EventManager();

//       mgr.createAndStoreEvent("My Event", new Date());
//       List<Event>  events = mgr.listEvents();
//       for (Event e :events)
//       {
//    	   System.out.println(e.getId());
//    	   System.out.println(e.getTitle());
//    	   System.out.println(e.getDate());
//    	   System.out.println(e.getIsRead());
//       }
        try
        {
        	//mgr.addPersonToEvent(3L,8L);
        	//mgr.addEventToPerson(3L,11L);
        	//mgr.addEmailToPerson(3L,"1308811723@qq.com");
        	Person person = new Person();
        	
        	person.setAge(21);
        	person.setFirstname("阮");
        	person.setLastname("从");
        	mgr.updatePerson(1L,person);
//        	Person person = new Person();
//        	person.setAge(25);
//        	person.setFirstname("dfdf");
//        	person.setLastname("dfd");
//        	System.out.println(mgr.addPerson(person));
        }finally
        {
        	HibernateUtil.getSessionFactory().close();
        }
    }

    public void saveEvent(Event event)
    {
         
    	   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	   session.beginTransaction();
    	   session.save(event);
    	   session.getTransaction().commit();
    }

    
    public List<Event> listEvents()
    {
    	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         List<Event> result = session.createQuery("from Event").list();
         session.getTransaction().commit();
         return result;
    }
    
    public long addPerson(Person person)
    {
    	 Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction trans = null;
         long personId = 0; 
         try
         {
        	 trans = session.beginTransaction();
        	 personId = (Long)session.save(person);
             trans.commit();
         }catch (Exception e) {
        	 e.printStackTrace();
			if (trans != null)
			{
				trans.rollback();
			}
		}finally
		{
			session.close();
		}
         return personId;
    }
    
    public void addEventToPerson(Long personId, Long eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);
        Event anEvent = (Event) session.load(Event.class, eventId);
       
        aPerson.getEvents().add(anEvent);
        session.getTransaction().commit();
    }
    
    public void addPersonToEvent(Long personId, Long eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);
        Event anEvent = (Event) session.load(Event.class, eventId);
        System.out.println(anEvent.getParticipants().size());
        anEvent.getParticipants().add(aPerson);
        session.getTransaction().commit();
    }
    
    public void addEmailToPerson(Long personId,String email)
    {
    	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Person aPerson = (Person) session.load(Person.class, personId);
         aPerson.getEmails().add(email);
         session.getTransaction().commit();
    }
    
    public void updatePerson(Long personId,Person p)
    {
    	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         
         Person aPerson = (Person) session.load(Person.class, personId);
         aPerson.setAge(p.getAge());
         aPerson.setFirstname(p.getFirstname());
         aPerson.setLastname(p.getLastname());
         session.getTransaction().commit();
    }
}