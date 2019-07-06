package PostConstructViaGuiceCustomImplementation;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ApplicationModule());
		MessageService messageService = injector.getInstance(MessageService.class);
		
		messageService.popMessage();
	}
}
