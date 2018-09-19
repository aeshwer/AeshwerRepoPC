package JPA.lazyFetch;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide4 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="staff_id", nullable=false)
	private String staffId;	
	
	private String name;
	private Integer salary;
	
	@OneToMany(mappedBy="guide", cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)
	private Set<Student4> students = new HashSet<Student4>();	
	
	public Guide4() {}
	public Guide4(String staffId, String name, Integer salary) {
		this.staffId = staffId;
		this.name = name;
		this.salary = salary;
	}
	
	public Set<Student4> getStudents() {
		return students;
	}	
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public void addStudent(Student4 student) {
		students.add(student);
		student.setGuide(this);
	}
	
}	







