package ManyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import OneToMany.Student3;

//Inverse End entity
@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="actors")
	private Set<Movie> movies = new HashSet<Movie>();
	
	public Actor() {
	}

	public Actor(String name) {
		this.name = name;
	}
	
	public Set<Movie> getMovies() {
		return movies;
	}

	// trying to add helper function but did not achieve results
	public void addMovies(Set<Movie> movie) {
		
		for(Movie m : movie) 
		{
			movies.add(m);
			Set<Actor> set = m.getActors();
        	set.add(this);
			m.setActors(set);
		} 
	}
}