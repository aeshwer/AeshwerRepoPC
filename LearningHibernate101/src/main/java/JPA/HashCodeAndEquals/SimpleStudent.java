package JPA.HashCodeAndEquals;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SimpleStudent {
	
	private Long id;
	
	private String enrollmentId;	
	
	private String name;
	
	public SimpleStudent() {}
	public SimpleStudent(String enrollmentId, String name) {
		this.enrollmentId = enrollmentId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "JPAStudent [id=" + id + ", enrollmentId=" + enrollmentId
				+ ", name=" + name + ", " +" ]";
	}

	// observe the use of HashCodeBuilder and Equals Builder
		
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(enrollmentId).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SimpleStudent)) return false;
		SimpleStudent other = (SimpleStudent) obj;
		return new EqualsBuilder().append(enrollmentId, other.enrollmentId).isEquals();
	}
	 	
}
