package LearnMapBinder;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;

public class NotificationModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(NotificationService.class);
		this.bindNotifiersByMapBinder();
	}

	private void bindNotifiersByMapBinder() {
		MapBinder<String, INotificication> mapbinder
        = MapBinder.newMapBinder(binder(), String.class, INotificication.class);
		
		mapbinder.addBinding("1").to(FirstNotifier.class).in(Singleton.class);
		mapbinder.addBinding("2").to(SecondNotifier.class).in(Singleton.class);
	}
}
