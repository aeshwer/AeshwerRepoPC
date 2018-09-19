package JPA.Basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message2")
public class Message2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")	
	private Long id;
	
	@Column(name="TEXT")	
	private String text;
	
	public Message2() {}
	public Message2(String text) {
		this.text = text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}

























