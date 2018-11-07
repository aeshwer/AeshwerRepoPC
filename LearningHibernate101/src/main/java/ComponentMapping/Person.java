package ComponentMapping;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String name;

	// we can give overrides here if we want to get some custom name for this particular Person entity table columns comming from Address via composition.
	// else we can give these in Address class itself. 
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="address_street")),
		@AttributeOverride(name="city", column=@Column(name="address_city"))
	})
	private Address address;
	
	// we can compose n number of times
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HomeAaddress_street")),
		@AttributeOverride(name="city", column=@Column(name="HomeAddress_city")),
		@AttributeOverride(name="zipcode", column=@Column(name="HomeAddress_zipcode"))
	})
	private Address homeAddress;

	public Person() {}	
	
	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
	}

}
















