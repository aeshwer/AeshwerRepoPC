package JPA.Basics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			Message2 msg= new Message2("Hello World with Hibernate as JPA Provider");
			em.persist(msg);

			txn.commit();
		}	
		catch(Exception e) {
			if(txn != null) { txn.rollback(); }
			e.printStackTrace();
		}	finally {
			if(em != null) { em.close(); }
		}

	}
}
