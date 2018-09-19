package JPA.lazyFetch;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OneToMany.Guide3;
import OneToMany.Student3;

public class App {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			
			Guide4 guide1 = new Guide4("2000MO10789", "Mike Lawson", 1000);
			Guide4 guide2 = new Guide4("2000IM10901", "Ian Lamb", 2000);

			Student4 student1 = new Student4("2014JT50123", "John Smith", guide1);
			Student4 student2 = new Student4("2014AL50456", "Amy Gill", guide1);

			guide1.getStudents().add(student1);
			guide2.getStudents().add(student2);

			em.persist(guide1);
			em.persist(guide2);


			//Lazy Collection Fetching with default settings(fetch=FetchType.LAZY for collection associations)
			// Hibernate here gives a proxy object which is small object as compared to Student collection object and fetch full data only when needed
			Guide4 guide = em.find(Guide4.class, 2L);
			Set<Student4> students = guide.getStudents();
			int numberOfStudents = students.size();  
			System.out.println("###########-------Number of students--------########### : "+ numberOfStudents);

			//Eager Fetching with default settings (fetch=FetchType.EAGER for single point associations)
			//Student4 student = em.find(Student4.class, 2L);

			txn.commit();
		}	catch(Exception e) {
			if(txn != null) { txn.rollback(); }
			e.printStackTrace();
		}	finally {
			if(em != null) { em.close(); }
		}
	}
}