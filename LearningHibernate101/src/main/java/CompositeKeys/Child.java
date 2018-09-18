package CompositeKeys;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

//Parent(One) -> Child(Many)
// child is the ownwer of this relation
@Entity
public class Child {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumns({
		@JoinColumn(name="firstname_fk", referencedColumnName="firstname"),
		@JoinColumn(name="lastname_fk", referencedColumnName="lastname")
	})
	private Parent parent;

	public Child() {}
	public Child(String name) {
		this.name = name;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

}
