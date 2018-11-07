package Basics;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory factory = buildSessionfactory();

	private static SessionFactory buildSessionfactory() {
		
		try{
		/*Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());*/
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();
			
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
