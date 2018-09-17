package OneToMany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student3 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="enrollment_id", nullable=false)
	private String enrollmentId;	
	
	private String name;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="guide_id")
	private Guide3 guide;
	
	public Student3() {}
	public Student3(String enrollmentId, String name, Guide3 guide) {
		this.enrollmentId = enrollmentId;
		this.name = name;
		this.guide = guide;
	}
	
	public Guide3 getGuide() {
		return guide;
	}
	public void setGuide(Guide3 guide) {
		this.guide = guide;
	}
	
}



