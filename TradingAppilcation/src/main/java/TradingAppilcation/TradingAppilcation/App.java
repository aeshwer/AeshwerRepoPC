package TradingAppilcation.TradingAppilcation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.Guice;
import com.google.inject.Injector;

import Business.TradePricingCalculation;
import Domain.DummyTradeCreator;
import Domain.Trade;
import Domain.TradeDomainToPersistableMapper;
import PersistableEntity.TradeDAO;
import PersistableEntity.TradePersistable;

/**
 * @author Aeshwer.Tyagi
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

		//Persisting
		TradeDAO dao = new TradeDAO(mapper.DomainToPersistableMapper());
		dao.persist();
		
		//TradeGateway fetch = new TradeFetcher();
		//System.out.println("Trade is:" + fetch.findTradeById("1"));
	}
	
}
