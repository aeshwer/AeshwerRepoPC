package Basics;

public class Message {

	private Long ids;
	private String text;

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
