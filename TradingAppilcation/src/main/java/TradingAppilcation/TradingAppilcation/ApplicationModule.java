package TradingAppilcation.TradingAppilcation;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import Business.AbstractPriceGenerator;
import Business.TradePricingCalculation;
import Domain.ITrade;
import Domain.Trade;
import PersistableEntity.TradeDAO;
import Util.TradeGateway;

public class ApplicationModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(ITrade.class).annotatedWith(Names.named("Real")).to(Trade.class);
		bind(AbstractPriceGenerator.class).to(TradePricingCalculation.class);
		bind(TradeGateway.class).to(TradeDAO.class);
	}

}
