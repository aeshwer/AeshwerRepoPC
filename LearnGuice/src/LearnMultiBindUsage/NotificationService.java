package LearnMultiBindUsage;

import java.util.Set;

import com.google.inject.Inject;

public class NotificationService {
	
	private Set<INotificication> allStreamingNotifiers;

	@Inject
	public NotificationService(final Set<INotificication> allStreamingNotifiers) {
		this.allStreamingNotifiers = allStreamingNotifiers;
	}

	public void notifierAPI() {
		for(INotificication notifier : allStreamingNotifiers ) 
		{
			notifier.sendNotification();
		}
	}
}
