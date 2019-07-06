package PostConstructViaGuiceCustomImplementation;

public class Message implements IMessage  {
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void sayHello() {
		System.out.println("Hello World");
	}
}

