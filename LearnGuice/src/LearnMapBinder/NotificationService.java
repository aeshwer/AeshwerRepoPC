package LearnMapBinder;

import java.util.Map;
import java.util.Set;

import com.google.inject.Inject;

public class NotificationService {
	
	private Map<String,INotificication> allStreamingNotifiersMap;

	@Inject
	public NotificationService(final Map<String,INotificication> allStreamingNotifiersMap) {
		this.allStreamingNotifiersMap = allStreamingNotifiersMap;
	}

	public void notifierAPI() {
		for(Map.Entry<String,INotificication> map : allStreamingNotifiersMap.entrySet() ) 
		{
			map.getValue().sendNotification();
		}
	}
}
