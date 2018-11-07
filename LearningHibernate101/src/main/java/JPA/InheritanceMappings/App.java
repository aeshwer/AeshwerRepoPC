package JPA.InheritanceMappings;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {
public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
        		try {
        			txn.begin();
        	
        			//Persisting a Cat and a Dog object
        			Cat cat = new Cat(); 
        			cat.setName("Lucy");
        	
        			Dog dog = new Dog();
        			dog.setName("Oliver");
        	
        			em.persist(cat);
        			em.persist(dog);
        	
        			//Polymorphic Query
        			Query query = em.createQuery("select animal from Animal as animal");
        			List<Animal> animals = query.getResultList();
        			for (Animal animal : animals) {
        				System.out.println("##########--------Result 1 :" + animal);
        			}    
        	
        			//Querying Derived Class (Dog)
        			List<Dog> dogs =em.createQuery("select dog from Dog as dog").getResultList();
        			for (Dog dogItr : dogs) {
					System.out.println("##########--------Result 2 :" + dogItr);
				}
   
	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(em != null) { em.close(); }
        		}
        
	}
}