package PostConstructViaGuiceCustomImplementation;

import javax.annotation.PostConstruct;

import com.google.inject.Inject;

import PostConstructImplementation.PostConstructObject;

public class MessageService implements PostConstructObject{
	
	private Message message;

	@Inject
	public MessageService(final Message message) {
		this.message = message;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Hello From init method of Message Service");
	}
	
	public void popMessage() {
		this.message.sayHello();
	}

}
