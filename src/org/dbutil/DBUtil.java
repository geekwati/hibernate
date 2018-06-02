package org.dbutil;




import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBUtil {
	private static Configuration cfg;
	private static SessionFactory factory;
	private static Session session;
	private static Transaction tx;
	
	static {
		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	}
	
	private static void init() {
		factory = cfg.buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
	}
	private static void destroy() {
		tx.commit();
		session.close();
		factory.close();
	}
	public List<Object> getList(String queryString) {
		init();
		Query query =  session.createQuery(queryString);
		
		
		@SuppressWarnings("unchecked")
		List<Object> l = (ArrayList<Object>)query.list();
		destroy();
		return l;
	}
	public boolean save(Object ob) {
		init();
		try {
		session.save(ob);
		//session.persist(ob);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		destroy();
		return true;
	}
	public  Object fetch(Object ob, int id ) {
		init();
		//fetch record
		ob=session.get(ob.getClass(), id);
		destroy();
		return ob;
	}
	
}
