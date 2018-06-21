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
import Util.TradeGateway;

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
		TradeGateway dao = new TradeDAO();
		dao.persist(mapper.DomainToPersistableMapper());
		
		//Fetching
		TradeGateway fetchedTrade = new TradeDAO();
		System.out.println("Trade is:" + fetchedTrade.findTradeById("1"));
	}
	
}
