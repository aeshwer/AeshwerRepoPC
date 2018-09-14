/*  Do this in DB 
 * 	CREATE TABLE message(
	ids BIGINT(20) NOT NULL AUTO_INCREMENT,
	text VARCHAR(255) Null Default null,
 	PRIMARY KEY (ids)
);
 */
package Basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "message")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long ids;
	
	@Column(name="TEXT")
	private String text;
	
	public Message() {
	}

	public Message(String text) {
		this.text =text;
	}

	public Long getIds() {
		return ids;
	}

	public void setIds(Long ids) {
		this.ids = ids;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return ""+ ids + " "+ text;	
	}

}
