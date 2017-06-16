package LearnGuiceCalculatorModifyWithProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;

public class CalculatorModule extends AbstractModule{

	@Override
	protected void configure() {
		// If guice does not know how to create the instance... tell it who can through provider
		bind(ICalculator.class).toProvider(CalciSelector.class);
	}

}
