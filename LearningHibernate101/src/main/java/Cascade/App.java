package Cascade;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Basics.HibernateUtil;

public class App {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();
			// persisting Student object
			Guide2 guide = new Guide2("2000IM10901", "Ian Lamb", 2000);
			Student2 student = new Student2("2014AL50456", "Amy Gill", guide);
			
			//Exercise: java.lang.IllegalArgumentException: attempt to create delete event with null entity if we try to delete any of the 2 student entity as both as same guide
			// so we get this exception and need to be careful
			//Student2 student2 = new Student2("2014AL50457", "Finding Exception", guide);

			session.persist(student);
			//session.persist(student2);

			// deleting Student object
			Student2 studentDel = (Student2) session.get(Student2.class, 2L);
			session.delete(studentDel);

    		txn.commit();
		}	catch(Exception e) {
    			if(txn != null) { txn.rollback(); }
    			e.printStackTrace();
		}	finally {
				if(session != null) { session.close(); }
		}

}
}



