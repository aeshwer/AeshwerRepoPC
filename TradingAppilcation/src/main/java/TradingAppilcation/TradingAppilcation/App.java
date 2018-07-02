package TradingAppilcation.TradingAppilcation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.inject.Guice;
import com.google.inject.Injector;

import Business.TradePricingCalculation;
import Domain.DummyTradeCreator;
import Domain.Trade;
import Domain.TradeDomainToPersistableMapper;
import PersistableEntity.TradeDAO;
import PersistableEntity.TradePersistable;
import Util.NamedThreadFactory;
import Util.TradeRequest;
import Util.TradeRequestHandler;
import Util.TradeRequestType;

/**
 * @author Aeshwer.Tyagi
 *
 */
public class App
{
	public static void main( String[] args )
	{
		Injector injector = Guice.createInjector(new ApplicationModule());
		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
 		
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
 		TradeDAO dao = injector.getInstance(TradeDAO.class);
		for(TradePersistable itr2 : tradePersistableList)
		{	
			TradeRequestHandler handler = new TradeRequestHandler(dao, new TradeRequest(TradeRequestType.CREATE	, itr2),0);
			executorService.submit(handler);
			//dao.persist(itr2);
		}
		
		//Fetching
		TradeRequest fetchRequest = new TradeRequest(TradeRequestType.FETCH,null);
		System.out.println("Trade is:" + new TradeRequestHandler(dao, fetchRequest,1));
		System.out.println("Trade is:" + new TradeRequestHandler(dao, fetchRequest,2));
		System.out.println("Trade is:" + new TradeRequestHandler(dao, fetchRequest,3));
		System.out.println("Trade is:" + new TradeRequestHandler(dao, fetchRequest,4));
		System.out.println("Trade is:" + new TradeRequestHandler(dao, fetchRequest,5));
		
		//UpdateTrade
		TradeRequest updateRequest = new TradeRequest(TradeRequestType.UPDATE,null);
		System.out.println("Trade with Original Values:" + new TradeRequestHandler(dao, fetchRequest,1));
		new TradeRequestHandler(dao, updateRequest, 1);
		System.out.println("Updated Trade with New Values:" + new TradeRequestHandler(dao, fetchRequest,1));
		
	}
	
}
