package MappingCollectionsOfValueType;

import org.hibernate.Session;

import Basics.HibernateUtil;

public class App {

public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//persisting		
		Friend friend = new Friend("Mark Anderson", "markanderson@pluswhere.com");
		
		friend.getNicknames().add("Marky");
		friend.getNicknames().add("Marco");
		friend.getNicknames().add("Markster");
		//collection of embeddable Address object
		friend.getAddresses().add(new Address("street1", "city1", "zipcode1"));
		friend.getAddresses().add(new Address("street2", "city2", "zipcode2"));
		friend.getAddresses().add(new Address("street3", "city3", "zipcode3"));

		//Persisting
		session.persist(friend);		
		
		//retrieving		
		Friend friendRetrive = (Friend) session.get(Friend.class, 1L);
		System.out.println(friendRetrive);		
		
		session.getTransaction().commit();
		session.close();
		
	}
}