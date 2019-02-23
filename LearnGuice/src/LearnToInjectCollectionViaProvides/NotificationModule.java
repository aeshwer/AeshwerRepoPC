package LearnToInjectCollectionViaProvides;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class NotificationModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(NotificationService.class);
	}

	@Provides
	@Singleton
	public List<INotificication> getAllstreamingNotifiers(final FirstNotifier firstNotifier,
			final SecondNotifier SecondNotifier) {
		return Collections.unmodifiableList(Arrays.asList(firstNotifier, SecondNotifier));
	}

}
