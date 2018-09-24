package JPA.NPlus1Problem;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ManyToOne.Student;
import OneToMany.Guide3;
import OneToMany.Student3;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			//Adding data to guide and student table by adding a Guide and associating a Student with it
			Guide3 guide1 = new Guide3("2000DO10777", "David Crow", 3000);		
			Student3 student1 = new Student3("2014RG50347", "Rahul Singh");
			guide1.addStudent(student1);

			Guide3 guide2 = new Guide3("2000MO10789", "Mike Lawson", 1000);
			Student3 student2 = new Student3("2014JT50123", "John Smith");
			guide1.addStudent(student2);

			Guide3 guide3 = new Guide3("2000IM10901", "Ian Lamb", 2000);
			Student3 student3 = new Student3("2014AL50456", "Amy Gill");
			guide3.addStudent(student3);
			
			Student3 student4 = new Student3("2014AL50427", "Bruce Lee");
			
			em.persist(guide1);
			em.persist(guide2);
			em.persist(guide3);
			em.persist(student4);

			//Loading all the student objects
			Query query = em.createQuery("select student from Student3 as student");
			List<Student3> studentsList = query.getResultList();	
			System.out.println("##########------Data from  student table---------#############");
			for (Student3 studentItr : studentsList) {
				System.out.println(studentItr.getName() + ": " + studentItr.getEnrollmentId());
			}  

			//Loading all the students with their associated Guide objects with the Student objects selectively (whenever you need to load them eagerly)
			/*
			Query query = em.createQuery("select student from Student student left join fetch student.guide");
			List<Student> students = query.getResultList();	

			for (Student student : students) {
				//students who do not have a guide will not be loaded
				if(student.getGuide() != null) {				
					System.out.println(student.getName() + ": " + student.getEnrollmentId() + ": " + student.getGuide().getName());
				}
			}  		
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