package hibernate_first;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientForSave {
	public static void main(String[] args)
	 {
	 Configuration cfg = new Configuration();
	 cfg.configure("hibernate.cfg.xml"); 
	 
	 
	SessionFactory factory = cfg.buildSessionFactory();
	 Session session = factory.openSession();
	
	 Product p=new Product();
	 
	 p.setProductId(111);
	 p.setProName("tele");
	 p.setPrice(250);
	 
	 
	 Transaction tx = session.beginTransaction();
	 session.save(p);
	 System.out.println("Object saved successfully.....!!");
	 tx.commit();
	 session.close();
	 session = factory.openSession();
	 tx = session.beginTransaction();
	 Query query =  session.createQuery("FROM Product");
	 @SuppressWarnings("unchecked")
	List<Product> results =  (List<Product>)query.list();
	 for (Product prod : results) {
		 System.out.println(prod.getProName());
	 }
	 tx.commit();
	 session.close();
	 factory.close();
	 }
}
