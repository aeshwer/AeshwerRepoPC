package LearnMultiBindUsage;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class App {

	private static Injector injector;

	public static void main(String[] args) {

		System.out.println("Program Start");

		injector = Guice.createInjector(new NotificationModule());
		NotificationService notificationService = injector.getInstance(NotificationService.class);
		notificationService.notifierAPI();


		System.out.println("Program Ends");
	}
}
