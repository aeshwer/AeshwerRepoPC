package CompositeKeys;

import org.hibernate.Session;

import Basics.HibernateUtil;

public class CompositeForeignKeyClient {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//persisting		
		ParentPrimaryKey parentPrimaryKey = new ParentPrimaryKey("Gavin", "King");
		Parent parent = new Parent(parentPrimaryKey);
		session.persist(parent);
		
		//retrieving	
		Parent parentRetrived = (Parent) session.get(Parent.class, parentPrimaryKey);
		System.out.println(parentRetrived);
		
		session.getTransaction().commit();
		session.close();
	}
}
