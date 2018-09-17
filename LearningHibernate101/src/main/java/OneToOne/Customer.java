package OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//owner Entity
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	// observe here the unique constraint is used in one to one mappings 
	@OneToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="passport_id", unique=true)
	private Passport passport;
	
	public Customer() {}	
	public Customer(String name, Passport passport) {
		this.name = name;
		this.passport = passport;
	}
	
	public Passport getPassport() {
		return passport;
	}

}	
