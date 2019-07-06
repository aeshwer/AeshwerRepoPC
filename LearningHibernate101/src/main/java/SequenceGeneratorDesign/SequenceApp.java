package SequenceGeneratorDesign;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import JPA.Basics.Message2;

public class SequenceApp {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence1");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		
		Drafts draft1 = new Drafts("draft1"); //transient state        
		Drafts draft2 = new Drafts("draft2"); //transient state
		Drafts draft3 = new Drafts("draft3"); //transient state
		
		em.persist(draft1); //persistent state
		em.persist(draft2); //persistent state
		em.persist(draft3); //persistent state
		
		txn.commit();	
		em.close(); 
		
	}
}
