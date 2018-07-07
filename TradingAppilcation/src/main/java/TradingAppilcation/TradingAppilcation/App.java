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

import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

import Business.TradePricingCalculation;
import Domain.DummyTradeCreator;
import Domain.Trade;
import Domain.TradeDomainToPersistableMapper;
import PersistableEntity.TradeDAO;
import PersistableEntity.TradeDetailDAO;
import PersistableEntity.TradeDetailsPersistable;
import PersistableEntity.TradePersistable;
import TradeRequestHandler.TradeRequest;
import TradeRequestHandler.TradeRequestHandler;
import TradeRequestHandler.TradeRequestType;
import Util.LogManagerUtil;
import Util.NamedThreadFactory;

/**
 * @author Aeshwer.Tyagi
 *
 */
public class App
{
	final static Logger logger = LogManagerUtil.getLogger(App.class);

	private static Injector injector;

	private static ExecutorService executorService;

	private static CompletionService<Trade> completionService ;

	private static TradePricingCalculation tradePricingCalculation; 

	private static TradeDAO tradeDao;
	
	private static TradeDetailDAO tradeDetailDao;
	

	public static void main( String[] args ) throws InterruptedException, ExecutionException
	{
		injector = Guice.createInjector(new ApplicationModule());
		executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
		completionService = new ExecutorCompletionService<Trade>(executorService);

		//Persisting Trade
		tradeDao = injector.getInstance(TradeDAO.class);
		for(TradePersistable itr2 : retriveDummyTrades())
		{	
			TradeRequestHandler handler = new TradeRequestHandler(tradeDao, new TradeRequest(TradeRequestType.CREATE, itr2),0);
			completionService.submit(handler);
		}
		
		//Persisting Trade Detail
		tradeDetailDao = injector.getInstance(TradeDetailDAO.class);
		for( TradeDetailsPersistable itr3 : retriveDummyTradesDetailsFeeder())
		{	
			TradeRequestHandler handler = new TradeRequestHandler(tradeDetailDao, new TradeRequest(TradeRequestType.CREATE, itr3),0);
			completionService.submit(handler);
		}


		TimeUnit.MILLISECONDS.sleep(3000);// ensuring all trades are persisted before we fetch them
		//Fetching
		TradeRequest fetchRequest = new TradeRequest(TradeRequestType.FETCH,null);
		logger.info("*********Fetched Trade is:" +  completionService.submit(new TradeRequestHandler(tradeDao, fetchRequest,1)).get()+ "*******");
		logger.info("*********Fetched Trade is:" +  completionService.submit(new TradeRequestHandler(tradeDao, fetchRequest,2)).get()+ "*******");
		logger.info("*********Fetched Trade is:" +  completionService.submit(new TradeRequestHandler(tradeDao, fetchRequest,3)).get()+ "*******");
		logger.info("*********Fetched Trade is:" +  completionService.submit(new TradeRequestHandler(tradeDao, fetchRequest,4)).get()+ "*******");
		logger.info("*********Fetched Trade is:" +  completionService.submit(new TradeRequestHandler(tradeDao, fetchRequest,5)).get()+ "*******");

		TimeUnit.MILLISECONDS.sleep(3000);// ensuring all trades are fetched before we do some more operations

		//CopyTrade
		TradeRequest copyRequest = new TradeRequest(TradeRequestType.COPY,null);
		Future<Trade> copyTrade = completionService.submit(new TradeRequestHandler(tradeDao, copyRequest, 1));
		logger.info("***********Copy Trade: " + copyTrade.get() +" ***************");
	}

	private static List<TradePersistable> retriveDummyTrades() 
	{
		DummyTradeCreator dummyTrade = new DummyTradeCreator(injector.getInstance(Trade.class));
		List<Trade> listOfTrade = dummyTrade.CreatedummyTrade();
		List<TradePersistable> tradePersistableList =  new ArrayList<>();

		//Making Guice object of this entity
		tradePricingCalculation = injector.getInstance(TradePricingCalculation.class);

		for(Trade itr1 : listOfTrade)
		{
			TradeDomainToPersistableMapper mapper = new TradeDomainToPersistableMapper(itr1,tradePricingCalculation);
			tradePersistableList.add(mapper.DomainToPersistableMapper());
		}

		return tradePersistableList;
	}

	private static List<TradeDetailsPersistable> retriveDummyTradesDetailsFeeder() 
	{
		List<TradeDetailsPersistable> tradeDetailsPersistableList = new ArrayList<>();
		tradeDetailsPersistableList.add(new TradeDetailsPersistable(1,"Active","USD","Aeshwer"));
		tradeDetailsPersistableList.add(new TradeDetailsPersistable(2,"Active","EUR","Rohit"));
		tradeDetailsPersistableList.add(new TradeDetailsPersistable(3,"Active","JYP","Ved"));
		tradeDetailsPersistableList.add(new TradeDetailsPersistable(4,"Active","USD","Sam"));
		return tradeDetailsPersistableList;
	}

}
