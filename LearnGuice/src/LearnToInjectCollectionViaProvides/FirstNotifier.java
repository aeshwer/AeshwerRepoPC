package LearnToInjectCollectionViaProvides;

public class FirstNotifier implements INotificication {

	@Override
	public void sendNotification() {
		System.out.println("Notification from First Notifier");
	}
}
