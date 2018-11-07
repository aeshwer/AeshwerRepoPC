package JPA.FirstLevelCache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import JPA.Basics.Message2;

public class App {
		public static void main(String[] args) {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();
				Message2 msg= new Message2("Hello World with Hibernate as JPA Provider");  
				em.persist(msg); 
				em.getTransaction().commit();
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			
			
			//First-level Caching
			em.getTransaction().begin();

			Message2 message1 = em.find(Message2.class, 1L);
			Message2 message2 = em.find(Message2.class, 1L);// here we will not hit DB as entity manager will have it cached the first time

			em.getTransaction().commit();
			em.close();

			// Is First-level Caching still going work? Answer: No, we will have 2 seperate SQL select statement as the scope of First Level cache is Limited to Entity Manger
			/*
			EntityManager em1 = emf.createEntityManager();
			em1.getTransaction().begin();

			Message2 message1 = em1.find(Message2.class, 1L);

			em1.getTransaction().commit();
			em1.close();

			EntityManager em2 = emf.createEntityManager();
			em2.getTransaction().begin();

			Message2 message2 = em2.find(Message2.class, 1L);

			em2.getTransaction().commit();
			em2.close();
			*/

		}
	}