package TradingAppilcation.TradingAppilcation;

import com.google.inject.Guice;
import com.google.inject.Injector;

import Business.TradePricingCalculation;
import Domain.DummyTradeCreator;
import Domain.Trade;
import Domain.TradeDomainToPersistableMapper;
import PersistableEntity.TradeDAO;
import SearchTrade.TradeFetcher;
import Util.TradeGateway;
/**
 * Hello world!
 *
 */
public class App
{
	public static void main( String[] args )
	{
		Injector injector = Guice.createInjector(new ApplicationModule());
		DummyTradeCreator dummyTrade = new DummyTradeCreator(injector.getInstance(Trade.class));
		
		TradePricingCalculation tradePricingCalculation = new TradePricingCalculation(dummyTrade.CreatedummyTrade());
		TradeDomainToPersistableMapper mapper = new TradeDomainToPersistableMapper(dummyTrade.CreatedummyTrade(), tradePricingCalculation);

		TradeGateway dao = new TradeDAO(mapper.DomainToPersistableMapper());
		dao.persist();
		
		TradeGateway fetch = new TradeFetcher();
		System.out.println("Trade is:" + fetch.findTradeById("1"));
	}
}
