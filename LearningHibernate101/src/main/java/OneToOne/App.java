package OneToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Basics.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();

			Passport passport = new Passport("925076473");
			Customer customer = new Customer("Nicole Scott", passport);

			session.persist(customer);

			txn.commit();
		}	catch(Exception e) {
			if(txn != null) { txn.rollback(); }
			e.printStackTrace();
		}	finally {
			if(session != null) { session.close(); }
		}

	}
}
