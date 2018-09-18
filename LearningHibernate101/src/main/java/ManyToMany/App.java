package ManyToMany;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Basics.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
    		Transaction txn = session.getTransaction();
    		try {
    			txn.begin();
    	
    			//persisting the ManyToMany relationship between the Movie and Actor objects
    			Movie movie1 = new Movie("American Hustle");
    			Movie movie2 = new Movie("The Prestige");
    	
    			Actor actor1 = new Actor("Christian Bale");
    			Actor actor2 = new Actor("Hugh Jackman");
    	
    			movie1.getActors().add(actor1);
    	
    			movie2.getActors().add(actor1);
    			movie2.getActors().add(actor2);
    	
    			session.persist(movie1);
    			session.persist(movie2);

    			// Updating the inverse end (Actor)       	
	        	/*Movie movie = (Movie) session.get(Movie.class, 1L);
	        	Actor actor = (Actor) session.get(Actor.class, 2L);
	        	actor.getMovies().add(movie);*/
	        	
    			//updating the inverse end using the helper function so update is possible
    			// this a helper function call in an attempt to get update while updating the inverse end
	        	/*Movie movie = (Movie) session.get(Movie.class, 1L);
	        	Actor actor = (Actor) session.get(Actor.class, 2L);
	        	HashSet<Movie> set = new HashSet<Movie>();
	        	set.add(movie);
	        	actor.addMovies(set);*/
	  			       	
    	
    			// Updating the owner (Movie)    
	        	/*Movie movie = (Movie) session.get(Movie.class, 1L);
	        	Actor actor = (Actor) session.get(Actor.class, 2L);
	        	movie.getActors().add(actor);*/

    			txn.commit();
    		}	catch(Exception e) {
        			if(txn != null) { txn.rollback(); }
        			e.printStackTrace();
    		}	finally {
    				if(session != null) { session.close(); }
    		}

}
}


