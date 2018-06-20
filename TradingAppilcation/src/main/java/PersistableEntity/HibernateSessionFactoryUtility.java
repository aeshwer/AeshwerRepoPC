package PersistableEntity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Useless now
public class HibernateSessionFactoryUtility {

	public static SessionFactory factory;
	
	public HibernateSessionFactoryUtility() {
		
	}
	
	 public static synchronized SessionFactory getSessionFactory() {
	        if (factory == null) {
	            factory = new Configuration().configure("hibernate.cfg.xml").
	                    buildSessionFactory();
	        }
	        return factory;
	    }
}
