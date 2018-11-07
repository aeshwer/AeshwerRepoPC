package JPA.QueryLanguage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ManyToOne.Guide;
import OneToMany.Guide3;
import OneToMany.Student3;

public class App {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			Guide3 guide1 = new Guide3("2000MO10789", "Mike Lawson", 1000);
			Guide3 guide2 = new Guide3("2000IM10901", "Ian Lamb", 2000);

			Student3 student1 = new Student3("2014JT50123", "John Smith", guide1);
			Student3 student2 = new Student3("2014AL50456", "Amy Gill", guide1);

			guide1.getStudents().add(student1);
			guide1.getStudents().add(student2);

			em.persist(guide1);
			em.persist(guide2);

			//Querying Entities (we have used alisa. The 'as' keyword is optional)
			Query query = em.createQuery("select guide from Guide3 guide");
			List<Guide3> guides = query.getResultList();
			for (Guide3 guide : guides) {
				int i=0;
				System.out.println("##########--------Result 1 :"+guide);
			}
			
			Query query2 = em.createQuery("select guide.name from Guide3 guide");
			List<String> names = query2.getResultList();
			for (String name : names) {
				System.out.println("##########--------Result 2 Name :"+name);
			}
	
			//############################


			//Reporting Queries
			Query query3 = em.createQuery("select guide.name, guide.salary from Guide3 as guide");
			List<Object[]> resultList = (List<Object[]>)query3.getResultList();
			for (Object[] objects : resultList) {
				System.out.println("##########--------Result 3 "+"Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");				
			}
	
			//############################
	
	
			//Dynamic Queries
			String name = "Ian Lamb"; //simulating dynamic query
			Query query4 = em.createQuery("select guide from Guide3 as guide where guide.name = '" + name + "'"); // this syntax is vulnerable to SQL injection attack? How to solve
			Guide3 guide = (Guide3) query4.getSingleResult();
			System.out.println("##########--------Result 4 Fetched"+ guide);			
	
			Query query5 = em.createQuery("select guide from Guide3 as guide where guide.name = :name"); // solve by using named parameter
			query5.setParameter("name", "Ian Lamb");
			Guide3 guide5 = (Guide3) query5.getSingleResult();
			System.out.println("##########--------Result 5 Fetched"+guide5);      
	
			//############################
	
	
			//Chaining Method Calls
			Guide3 guide6 = (Guide3) em.createQuery("select guide from Guide3 as guide where guide.name = :name")
					        .setParameter("name", "Ian Lamb")
					        .getSingleResult();
			System.out.println("##########--------Result 6 Fetched"+guide6);      
	
			//############################
	
	
			//Wildcards
			Query query7 = em.createQuery("select guide from Guide3 as guide where guide.name like 'Mike%'");
			List<Guide3> guides7 = query7.getResultList();
			for (Guide3 guide7 : guides7) {
				System.out.println("##########--------Result 7 Fetched"+guide7);      
			}
	
			//############################
	

			//Native SQL Queries
			Query query8 = em.createNativeQuery("select * from Guide", Guide.class);
			List<Guide3> guides8 = query.getResultList();
			for (Guide3 guide8 : guides8) {
				System.out.println("##########--------Result 8 Fetched"+guide8);      
			}
	
			//############################	

			//Named Queries
			/*for this you have to put the named query in a orm.xml file kept in the META-INF folder
			List<Guide> guides = em.createNamedQuery("findByGuide")
					       						.setParameter("name", "Mike Lawson")
					       						.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/

			// Observe: There is a issue with the below mentioned statements: There is a overload of converting the Result Set to Guide object.
			// To solve this we use a aggregate function count to do our job
			int numOfGuides = em.createQuery("select guide from Guide3 as guide").getResultList().size();
			System.out.println("##########--------Result 9--[numOfGuides: " + numOfGuides + "]");
	
			//############################
	

			//Aggregate Functions
			Query query10 = em.createQuery("select count(guide) from Guide3 as guide");
			long numOfGuides2 = (long) query10.getSingleResult();
			System.out.println("##########--------Result 10--[numOfGuides: " + numOfGuides2 + "]");

			Query query11 = em.createQuery("select max(guide.salary) from Guide3 as guide");
			Integer maximumSalary = (Integer) query11.getSingleResult();
			System.out.println("##########--------Result 11--[maximumSalary: " + maximumSalary + "]");        	
	
			Query query12 = em.createQuery("select guide from Guide3 as guide where guide.salary = 1000");
			List<Guide3> guides12 = query12.getResultList();
			for (Guide3 guide12 : guides12) {
				System.out.println("##########--------Result 12" + guide12);
			}     	
	
			//############################	
	
			//Persisting a Student object which has no guide1
			Student3 student = new Student3("2014BE50789", "Bruce Lee");
			em.persist(student);
			Guide3 gui = new Guide3("1992JUL1607", "Aeshwer Tyagi", 3000);
			em.persist(gui);
	
			//############################	
	
			//Joining Associations
			Query query13 = em.createQuery("select student from Student3 as student join student.guide guide");
			List<Student3> students13 = query13.getResultList();
			for (Student3 student13 : students13) {
				System.out.println("##########--------Result 13 "+ student13);
			}
	
			Query query14 = em.createQuery("select student from Student3 as student left join student.guide guide");
			List<Student3> students14 = query14.getResultList();
			for (Student3 student14 : students14) {
				System.out.println("##########--------Result 14 "+student14);
			}
	
			Query query15 = em.createQuery("select student from Student3 as student right join student.guide guide");
			List<Student3> students15 = query15.getResultList();
			for (Student3 student15 : students15) {
				System.out.println("##########--------Result 15 "+ student15);
			}
	
			//############################

	
			//Fetching Associations
			//Using the FetchType.EAGER or LAZY
			/*Query query16 = em.createQuery("select guide from Guide3 as guide join guide.students student");
			List<Guide3> guides16 = query16.getResultList();
				for (Guide3 guide16 : guides16) {
				System.out.println("##########--------Result 16 "+ guide16);
			}*/
	
			/*
			Query query = em.createQuery("select guide from Guide guide join fetch guide.students student");
			List<Guide> guides = query.getResultList();
			*/

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
}

