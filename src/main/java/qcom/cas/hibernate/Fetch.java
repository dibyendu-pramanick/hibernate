package qcom.cas.hibernate;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import net.sf.ehcache.CacheManager;
import qcom.cas.hibernate.pojo.Reader;
import qcom.cas.hibernate.pojo.Subscription;

public class Fetch {
	
	public static void main(String args[]) {
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session1 = factory.openSession();
	    Session session2 = factory.openSession();
	    Transaction  tx = session1.beginTransaction();
	    Reader r1 = session1.get(Reader.class, 1);
	    System.out.println("id - " + r1.getReaderId());
	    System.out.println("email - " + r1.getEmail());
	    System.out.println("First Name - " + r1.getFirstName());
	    System.out.println("Last Name - " + r1.getLastName());
	    Set<Subscription> subscription = r1.getSubscriptions();
	    for(Subscription s: subscription) {
	    	System.out.println("Subscription - " + s.getSubscriptionName());
	    }
	    //session.evict(r1);
	    Reader r2 = session2.get(Reader.class, 1);
	    //System.out.println(factory.getStatistics().getEntityFetchCount()); 
	    //tx.commit();
	    System.out.println(r2.getFirstName());
		session1.close();
		session2.close();
		factory.close();
	}

}
