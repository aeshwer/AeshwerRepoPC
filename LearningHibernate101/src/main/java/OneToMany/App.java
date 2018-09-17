// the one to many package example was a unidirectional one from student to guide ,,, here we aim at bi directional  and use oneToMany from guide side  
package OneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Basics.HibernateUtil;

public class App {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();

			Guide3 guide1 = new Guide3("2000MO10789", "Mike Lawson", 1000);
			Guide3 guide2 = new Guide3("2000IM10901", "Ian Lamb", 2000);

			Student3 student1 = new Student3("2014JT50123", "John Smith", guide1);
			Student3 student2 = new Student3("2014AL50456", "Amy Gill", guide1);

			guide1.getStudents().add(student1); // updating the inverse end and is needed if we persist the inverse end and want the owner to get persisted as well
			guide1.getStudents().add(student2);

			session.persist(guide1);
			session.persist(guide2);

			//Updating inverse end
			/*Guide3 guide = (Guide3) session.get(Guide3.class, 2L);        	
			Student3 student = (Student3) session.get(Student3.class, 2L);          	
			guide.getStudents().add(student);*/
			// observe after updating the inverse end that the value in the owner  table(student) is not updated . Why?? because it only care about itself and it was not the owner

			
			//Updating owner
    		Guide3 guide = (Guide3) session.get(Guide3.class, 2L);        	
    		Student3 student = (Student3) session.get(Student3.class, 2L);          	
    		student.setGuide(guide);
    		//observe here the thing we update in both table since we are updating the owner here so inverse end also gets updated
    		

			//Updating inverse end (after adding addStudent(Student) in Guide entity)
			/*
    		Guide guide = (Guide) session.get(Guide.class, 2L);        	
    		Student student = (Student) session.get(Student.class, 1L);          	
    		guide.addStudent(student);
			 */
			txn.commit();
		}	catch(Exception e) {
			if(txn != null) { txn.rollback(); }
			e.printStackTrace();
		}	finally {
			if(session != null) { session.close(); }
		}
	}
}
