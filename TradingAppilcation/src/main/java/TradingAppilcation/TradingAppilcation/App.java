package TradingAppilcation.TradingAppilcation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.inject.Guice;
import com.google.inject.Injector;

import Business.TradePricingCalculation;
import Domain.DummyTradeCreator;
import Domain.Trade;
import Domain.TradeDomainToPersistableMapper;
import PersistableEntity.TradeDAO;
import PersistableEntity.TradePersistable;
import TradeRequestHandler.TradeRequest;
import TradeRequestHandler.TradeRequestHandler;
import TradeRequestHandler.TradeRequestType;
import Util.NamedThreadFactory;

/**
 * @author Aeshwer.Tyagi
 *
 */
public class App
{
	public static void main( String[] args ) throws InterruptedException, ExecutionException
	{
		Injector injector = Guice.createInjector(new ApplicationModule());
		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
		CompletionService<Trade> completionService = new ExecutorCompletionService<Trade>(executorService);
 		
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
			completionService.submit(handler);
			//dao.persist(itr2);
		}
		
		TimeUnit.MILLISECONDS.sleep(3000);// ensuring all trades are persisted before we fetch them
		
		//Fetching
		TradeRequest fetchRequest = new TradeRequest(TradeRequestType.FETCH,null);
		System.out.println("*********Trade is:" + completionService.submit(new TradeRequestHandler(dao, fetchRequest,1)).get()+ "*******");
		System.out.println("*********Trade is:" + completionService.submit(new TradeRequestHandler(dao, fetchRequest,2)).get()+ "*******");
		System.out.println("*********Trade is:" + completionService.submit(new TradeRequestHandler(dao, fetchRequest,3)).get()+ "*******");
		System.out.println("*********Trade is:" + completionService.submit(new TradeRequestHandler(dao, fetchRequest,4)).get()+ "*******");
		System.out.println("*********Trade is:" + completionService.submit(new TradeRequestHandler(dao, fetchRequest,5)).get()+ "*******");
		
		TimeUnit.MILLISECONDS.sleep(3000);// ensuring all trades are fetched before we do some more operations
		
		//CopyTrade
		TradeRequest copyRequest = new TradeRequest(TradeRequestType.COPY,null);
		Future<Trade> copyTrade = completionService.submit(new TradeRequestHandler(dao, copyRequest, 1));
		System.out.println("*********Copy Trade :" + copyTrade.get()+"*******");
	}
}
