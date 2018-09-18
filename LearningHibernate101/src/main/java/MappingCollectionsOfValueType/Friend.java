package MappingCollectionsOfValueType;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;

	@ElementCollection
	@CollectionTable(name = "friend_nickname", joinColumns=@JoinColumn(name = "friend_id"))
	@Column(name = "nickname")
	private Collection<String> nicknames =  new ArrayList<String>();

	//collection of embeddable Address object [with default address specfic column names being overriden using @AttributeOverride]
	@ElementCollection
	@CollectionTable(name = "friend_address", joinColumns=@JoinColumn(name = "friend_id"))
	@AttributeOverrides( {
	} )
	private Collection<Address> addresses = new ArrayList<Address>();
	
	public Friend() {
		
	}
	
	public Friend(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public Collection<String> getNicknames() {
		return nicknames;
	}
	
	public Collection<Address> getAddresses() {
		return addresses;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", email=" + email + ", nicknames=" + nicknames + ", addresses=" + addresses+"]";
	}
	
}
