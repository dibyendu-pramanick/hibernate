package qcom.cas.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import qcom.cas.hibernate.pojo.Account;
import qcom.cas.hibernate.pojo.Employee;

public class OneToManyMapping {
	
	public static void main( String[] args ) {
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
	    
	    Account a1 = new Account();
	    a1.setAccountNumber("acc-1");
	    
	    Account a2 = new Account();
	    a2.setAccountNumber("acc-2");
	    
	    Set<Account> accounts = new HashSet<Account>();
	    accounts.add(a1);
	    accounts.add(a2);
	    
	    Employee employee1 = new Employee();
	    employee1.setFirstName("Dibyendu");
	    employee1.setLastName("Pramanick");
	    employee1.setEmail("test@gmail.com");
	    employee1.setAccount(accounts);
	    
	    Transaction  tx = session.beginTransaction();
	    session.save(employee1);
	    tx.commit();
		session.close();
		factory.close();
	}
	

}
