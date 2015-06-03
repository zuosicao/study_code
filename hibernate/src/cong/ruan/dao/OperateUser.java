package cong.ruan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cong.ruan.beans.User;

public class OperateUser
{
	public static void saveUser(User user)
	{
		Configuration config = new Configuration();
		config.configure();
		@SuppressWarnings("deprecation")
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(user);
		tran.commit();
		factory.close();
	}
	public static void main(String[] args)
	{
		User u1 = new User();
		u1.setUsername("ddd");
		saveUser(u1);
	}
}
