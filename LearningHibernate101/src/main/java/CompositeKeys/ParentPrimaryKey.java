package CompositeKeys;

import java.io.Serializable;

import javax.persistence.Embeddable;

// Encapsulate the Composite Primary Key attribute in a seperate class

@Embeddable
public class ParentPrimaryKey implements Serializable{
	
	private String firstName;
	
	private String lastName;
	
	public ParentPrimaryKey() {
	}
	
	public ParentPrimaryKey(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	//Why are we overriding the equals and hashcode, so we can compare 2 objects in the cache 
	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;		
		ParentPrimaryKey parentPrimaryKey = (ParentPrimaryKey) obj;		
		if (!firstName.equals(parentPrimaryKey.firstName)) return false;		
		if (!lastName.equals(parentPrimaryKey.lastName)) return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "ParentPrimaryKey [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
