/*
 * CREATE TABLE id_gen
( gen_name VARCHAR(80),
  gen_val NUMBER(20,0),
);

 */
package SequenceUsingTable;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InfoApp {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence1");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Information info1 = new Information("info1");
		Information info2 = new Information("info2");
		Information info3 = new Information("info3");
		Information info4 = new Information("info4");

		txn.begin();

		em.persist(info1);
		em.persist(info2);
		em.persist(info3);
		em.persist(info4);
		txn.commit();

	}

}
