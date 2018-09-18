package CompositeKeys;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Parent {
	
	@EmbeddedId
	private ParentPrimaryKey parentPrimaryKey;

	@OneToMany(mappedBy="parent",cascade = CascadeType.PERSIST)
	private Set<Child> children;
	
	
	public Parent() {
	}
	
	public Parent(ParentPrimaryKey parentPrimaryKey) {
		this.parentPrimaryKey = parentPrimaryKey; 
	}
	
	public void addChild(Child child) {
		children.add(child);
		child.setParent(this);
	}
}
