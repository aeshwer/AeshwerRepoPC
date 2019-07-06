//https://thoughts-on-java.org/hibernate-tips-use-custom-sequence/
//https://thoughts-on-java.org/custom-sequence-based-idgenerator/
package SequenceGeneratorDesign;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Drafts")
public class Drafts {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drafts_generator")
	@SequenceGenerator(name="drafts_generator", sequenceName = "drafts_seq")
	/*@GenericGenerator(name = "drafts_seq", strategy = "SequenceGeneratorDesign.DraftIdStringAppenderGenerator",  parameters = {
			@Parameter(name = DraftIdStringAppenderGenerator.INCREMENT_PARAM, value = "800") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drafts_seq")*/
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	private String stringJSON;

	public Drafts() {
	}

	public Drafts(String stringJSON) {
		this.stringJSON = stringJSON;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStringJSON() {
		return stringJSON;
	}

	public void setStringJSON(String stringJSON) {
		this.stringJSON = stringJSON;
	}

}
