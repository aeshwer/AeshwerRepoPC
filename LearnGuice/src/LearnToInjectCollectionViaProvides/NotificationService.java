package LearnToInjectCollectionViaProvides;

import java.util.List;

import com.google.inject.Inject;

public class NotificationService {
	
	private List<INotificication> allStreamingNotifiers;

	@Inject
	public NotificationService(final List<INotificication> allStreamingNotifiers) {
		this.allStreamingNotifiers = allStreamingNotifiers;
	}

	public void notifierAPI() {
		for(INotificication notifier : allStreamingNotifiers ) 
		{
			notifier.sendNotification();
		}
	}
}
