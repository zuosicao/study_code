package cong.ruan.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.tutorial.domain.Bed;
import org.hibernate.tutorial.util.HibernateUtil;

public class BedDao
{
	public String addBed(Bed theBed)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		String bedId = (String)session.save(theBed);
		trans.commit();
		HibernateUtil.getSessionFactory().close();
		return bedId;
	}
	
	public static void main(String[] args)
	{
		Bed b = new Bed();
		b.setId("1101010423");
		b.setBedName("bedName");
		BedDao dao = new BedDao();
		dao.addBed(b);
		HibernateUtil.getSessionFactory().close();
	}
}
