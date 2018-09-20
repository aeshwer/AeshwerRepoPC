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
				System.out.println("##########--------Result :"+guide);
			}
			
			Query query2 = em.createQuery("select guide.name from Guide3 guide");
			List<String> names = query2.getResultList();
			for (String name : names) {
				System.out.println("##########--------Result Name :"+name);
			}
	
			//############################


			//Reporting Queries
			Query query3 = em.createQuery("select guide.name, guide.salary from Guide3 as guide");
			List<Object[]> resultList = (List<Object[]>)query3.getResultList();
			for (Object[] objects : resultList) {
				System.out.println("##########--------Result"+"Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");				
			}
	
			//############################
	
	
			//Dynamic Queries
			String name = "Ian Lamb"; //simulating dynamic query
			Query query4 = em.createQuery("select guide from Guide3 as guide where guide.name = '" + name + "'"); // this syntax is vulnerable to SQL injection attack? How to solve
			Guide3 guide = (Guide3) query4.getSingleResult();
			System.out.println("##########--------Result Fetched"+ guide);			
	
			Query query5 = em.createQuery("select guide from Guide3 as guide where guide.name = :name"); // solve by using named parameter
			query5.setParameter("name", "Ian Lamb");
			Guide3 guide5 = (Guide3) query5.getSingleResult();
			System.out.println("##########--------Result Fetched"+guide);      
	
			//############################
	
	
			//Chaining Method Calls
			/*
			Guide guide = (Guide) em.createQuery("select guide from Guide guide where guide.name = :name").
					        .setParameter("name", "Ian Lamb")
					        .getSingleResult();
			System.out.println(guide);
			*/
	
			//############################
	
	
			//Wildcards
			/*
			Query query = em.createQuery("select guide from Guide guide where guide.name like 'm%'");
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/
	
			//############################
	

			//Native SQL Queries
			/*
			Query query = em.createNativeQuery("select * from Guide", Guide.class);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/
	
			//############################	

			//Named Queries
			/*
			List<Guide> guides = em.createNamedQuery("findByGuide")
					       						.setParameter("name", "Mike Lawson")
					       						.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			*/

			/*
			int numOfGuides = em.createQuery("select guide from Guide guide").getResultList().size();
			System.out.println("[numOfGuides: " + numOfGuides + "]");
			*/
	
			//############################
	

			//Aggregate Functions
			/*
			Query query = em.createQuery("select count(guide) from Guide guide");
			long numOfGuides = (long) query.getSingleResult();
			System.out.println("[numOfGuides: " + numOfGuides + "]");
			*/

			/*
			Query query = em.createQuery("select max(guide.salary) from Guide guide");
			Integer maximumSalary = (Integer) query.getSingleResult();
			System.out.println("[maximumSalary: " + maximumSalary + "]");        	
			*/
	
			/*
			Query query = em.createQuery("select guide from Guide guide where guide.salary = 1000");
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}     	
			*/
	
			//############################	
	
			//Persisting a Student object
			/*
			Student student = new Student("2014BE50789", "Bruce Lee");
			em.persist(student);
			*/
	
			//############################	
	
			//Joining Associations
			/*
			Query query = em.createQuery("select student from Student student join student.guide guide");
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/
	
			/*
			Query query = em.createQuery("select student from Student student left join student.guide guide");
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/
	
			/*
			Query query = em.createQuery("select student from Student student right join student.guide guide");
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			*/
	
			//############################

	
			//Fetching Associations
			/*
			Query query = em.createQuery("select guide from Guide guide join guide.students student");
			List<Guide> guides = query.getResultList();
			*/
	
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

