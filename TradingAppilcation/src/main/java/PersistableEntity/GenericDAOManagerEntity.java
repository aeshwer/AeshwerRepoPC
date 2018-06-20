package PersistableEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.inject.Inject;

import Domain.IEntity;

public class GenericDAOManagerEntity {

	private static SessionFactory sessionFactory; 
	
	private static Session session;
	
	public GenericDAOManagerEntity() {
		this(sessionFactory);
	}

	public GenericDAOManagerEntity(SessionFactory sessionFactory) {
		this.sessionFactory = HibernateSessionFactoryUtility.getSessionFactory();
	}

	void Perist(IEntity entity) 
	{
		try {
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
