package ComponentMapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Basics.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			Address address = new Address("200 E Main St", "Seattle", "85123");
        			Person person = new Person("Ruby", address);
        	
        			session.save(person);
	        
	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}












