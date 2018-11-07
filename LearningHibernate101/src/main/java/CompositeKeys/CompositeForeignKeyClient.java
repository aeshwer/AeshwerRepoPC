package CompositeKeys;

import org.hibernate.Session;
import Basics.HibernateUtil;

public class CompositeForeignKeyClient {
	
public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//persisting		
		ParentPrimaryKey parentPrimaryKey = new ParentPrimaryKey("Charlotte", "Crawford");
		Parent parent = new Parent(parentPrimaryKey);
		
		Child child1 = new Child("Ruby");
		Child child2 = new Child("Groovy");
		
		parent.addChild(child1);
		parent.addChild(child2);
		
		session.persist(parent);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
