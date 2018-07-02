package TradingAppilcation.TradingAppilcation;

import java.util.ArrayList;
import java.util.List;

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
		List<Trade> listOfTrade = dummyTrade.CreatedummyTrade();
		List<TradePersistable> tradePersistableList =  new ArrayList<>();
		
		//Making guice object of this entity
		TradePricingCalculation tradePricingCalculation = injector.getInstance(TradePricingCalculation.class);
		
		for(Trade itr1 : listOfTrade)
		{
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
		System.out.println("Updated Trade with New Values:" + fetchedTrade.findTradeById(1));
		
	}
	
}
