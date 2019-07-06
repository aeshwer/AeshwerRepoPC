package SequenceUsingTable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Information")
public class Information {

	/*@Id
	@TableGenerator(name = "information_gen", table = "id_gen",pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "information_gen")*/
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="info_seq")
	@SequenceGenerator(
		name="info_seq",
		sequenceName="info_sequence",
		allocationSize=1
	)
	private Long id;

	private String stringJSON;

	public Information() {
	}

	public Information(String stringJSON) {
		this.stringJSON = stringJSON;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStringJSON() {
		return stringJSON;
	}

	public void setStringJSON(String stringJSON) {
		this.stringJSON = stringJSON;
	}



}
