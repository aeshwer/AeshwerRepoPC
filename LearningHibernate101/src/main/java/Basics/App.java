package Basics;

import org.hibernate.Session;

public class App {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Message message = new Message("Hello World");
		session.save(message);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
