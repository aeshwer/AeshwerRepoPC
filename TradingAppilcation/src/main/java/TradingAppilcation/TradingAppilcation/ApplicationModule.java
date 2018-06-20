package TradingAppilcation.TradingAppilcation;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;

import Domain.Trade;

public class ApplicationModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(Trade.class);
	}

}
