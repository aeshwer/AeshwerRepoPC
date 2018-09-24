package JPA.InheritanceMappings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy=InheritanceType.JOINED)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Animal {
	@Id 
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.TABLE) // to be used when using TABLE_PER_CLASS strategy
	private Long id;

	//@Column(nullable=false) // cannot be used when using SINGLE_TABLE strategy
	private String name;	

	public void setName(String name) { 	
		this.name = name; 
	}

	public abstract String makeNoise();

	public String toString() {
		return name + " making " + makeNoise() + " noises";
	}	

}
