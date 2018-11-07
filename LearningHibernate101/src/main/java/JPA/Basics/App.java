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

			Message2 msg= new Message2("Hello World with Hibernate as JPA Provider");  // Transient State
			
			em.persist(msg);//Persistent State -- here the message object has a database identity and will have its primary key value set as its database Identifier 
			//Once the message object becomes a persistent object then it gets managed by the entity manager for the duration of the Transaction.
			
			txn.commit(); 
		}	
		catch(Exception e) {
			if(txn != null) { txn.rollback(); }
			e.printStackTrace();
		}	finally {
			if(em != null) { 
				em.close(); // Once Entity Manager is closed the message Becomes detached state 
			}
		}

	}
}
