package PersistableEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Domain.IEntity;

public class GenericDAOManagerEntity {

	private SessionFactory sessionFactory; 
	
	private Session session;

	public GenericDAOManagerEntity() {
		
	}

	void Perist(IEntity entity) 
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
		}
	}
}
