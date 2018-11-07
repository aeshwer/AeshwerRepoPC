package ComponentMapping;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String street;
	private String city;
	@Column(name="address_zipcode")
	private String zipcode;
	
	public Address() {}
	public Address(String street, String city, String zipcode) {
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}	
	
}







