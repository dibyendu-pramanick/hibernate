package qcom.cas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import qcom.cas.hibernate.pojo.Address;
import qcom.cas.hibernate.pojo.Student;

/**
 * Hello world!
 *
 */
public class One2OneMapping 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
	    
	    Student s = new Student();
	    //s.setId(101);
	    
	    s.setGroup("test");
	    s.setName("Dibyendu");
	    
	    Address address = new Address();
	    address.setId(1);
	    address.setPlace("Bangalore");
	    s.setId(address.getId());
	    address.setStudent(s);
	    
	    Transaction  tx = session.beginTransaction();
	    session.save(address);
	    tx.commit();
		session.close();
		factory.close();
    }
}
