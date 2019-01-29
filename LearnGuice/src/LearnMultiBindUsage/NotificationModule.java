package LearnMultiBindUsage;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class NotificationModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(NotificationService.class);
		this.bindNotifiers();
	}

	private void bindNotifiers() {
		final Multibinder<INotificication> notifiers = Multibinder.newSetBinder(this.binder(),
				INotificication.class);
		notifiers.addBinding().to(FirstNotifier.class).in(Singleton.class);
		notifiers.addBinding().to(SecondNotifier.class).in(Singleton.class);

	}
}
