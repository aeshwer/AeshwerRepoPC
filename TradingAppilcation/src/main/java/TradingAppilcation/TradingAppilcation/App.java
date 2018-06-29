package TradingAppilcation.TradingAppilcation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		List<TradePersistable> tradePersistableList =  new ArrayList<>();
		List<Trade> listOfTrade = dummyTrade.CreatedummyTrade();
		
		for(Trade itr1 : listOfTrade)
		{
			TradePricingCalculation tradePricingCalculation = new TradePricingCalculation(itr1);
			TradeDomainToPersistableMapper mapper = new TradeDomainToPersistableMapper(itr1,tradePricingCalculation);
			tradePersistableList.add(mapper.DomainToPersistableMapper());
		}

		//Persisting
 		TradeGateway dao = new TradeDAO();
		for(TradePersistable itr2 : tradePersistableList)
		{
			dao.persist(itr2);
		}
		
		//Fetching
		TradeGateway fetchedTrade = new TradeDAO();
		System.out.println("Trade is:" + fetchedTrade.findTradeById(1));
		System.out.println("Trade is:" + fetchedTrade.findTradeById(2));
		System.out.println("Trade is:" + fetchedTrade.findTradeById(3));
		System.out.println("Trade is:" + fetchedTrade.findTradeById(4));
		System.out.println("Trade is:" + fetchedTrade.findTradeById(5));
		
		//UpdateTrade
		System.out.println("Trade with Original Values:" + fetchedTrade.findTradeById(1));
		
	}
	
}
