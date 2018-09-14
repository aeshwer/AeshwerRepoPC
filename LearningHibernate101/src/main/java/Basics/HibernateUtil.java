package Basics;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory = buildSessionfactory();

	private static SessionFactory buildSessionfactory() {
		
		try{
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		}
		catch(Throwable ex) 
		{
			System.err.println("Session factory creation failed"+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() 
	{
		return factory;
	}
}
