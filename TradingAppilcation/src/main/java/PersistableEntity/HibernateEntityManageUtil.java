package PersistableEntity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateEntityManageUtil {

	public static EntityManagerFactory factory;
	
	public HibernateEntityManageUtil() {
		
	}
	
	 public static synchronized EntityManagerFactory getEntityManager() {
	        if (factory == null) {
	            factory =  Persistence.createEntityManagerFactory("persistence");
	        }
	        return factory;
	    }
}
