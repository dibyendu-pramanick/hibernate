package qcom.cas.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import qcom.cas.hibernate.pojo.Reader;
import qcom.cas.hibernate.pojo.Subscription;

public class ManyToManyMapping {
	
	public static void main( String[] args ) {
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
	    
	    Subscription s1 = new Subscription();
	    s1.setSubscriptionName("netflix");
	    
	    Subscription s2 = new Subscription();
	    s2.setSubscriptionName("hoichoi");
	    
	    
	    Set<Subscription> subscriptions = new HashSet<Subscription>();
	    subscriptions.add(s1);
	    subscriptions.add(s2);
	    
	    Reader r1 = new Reader();
	    r1.setEmail("test1@gmail.com");
	    r1.setFirstName("Dibyendu");
	    r1.setLastName("Pramanick");
	    
	    Reader r2 = new Reader();
	    r2.setEmail("test2@gmail.com");
	    r2.setFirstName("Dibyendu2");
	    r2.setLastName("Pramanick2");
	    
	   
	    
	   /* Set<Reader> readers = new HashSet<Reader>();
	    readers.add(r1);
	    readers.add(r2);*/
	    
	    r1.setSubscriptions(subscriptions);
	    r2.setSubscriptions(subscriptions);
	    
	    Transaction  tx = session.beginTransaction();
	    session.save(r1);
	    session.save(r2);
	    
	    tx.commit();
		session.close();
		factory.close();
	    
	}

}
