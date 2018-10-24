package com.trading.entryPoint.Function;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.trading.DummyDataSetGenerator.TradeDataSetGenerator;
import com.trading.commons.util.LogManagerUtil;
import com.trading.commons.util.NamedThreadFactory;
import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;

public class ExposedTradeFunction {

	private TradeCaptureService tradeCaptureService;
	private ExecutorService executorService;
	private TradeResponse response;
	private static Logger logger;

	@Inject
	public ExposedTradeFunction(final TradeCaptureService tradeCaptureService) {
		this.tradeCaptureService = tradeCaptureService;
		this.executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
		logger = LogManagerUtil.getLogger(ExposedTradeFunction.class);
	}

	public void updateTrade() throws InterruptedException{
		//Will need to add UI support Later,using dummy data set as for now
		for(Trade trade : TradeDataSetGenerator.retriveDummyTradesFeeder()) {
			this.executorService.submit(
					() -> this.updateDelegate(trade));
		}
		//CheckingUpdate
		TimeUnit.MILLISECONDS.sleep(3000);// ensuring all trades are persisted before we update them
		for(Trade trade : TradeDataSetGenerator.retriveDummyTradesForUpdateOperation()) {
			this.executorService.submit(
					() -> this.updateDelegate(trade));
		}
	}

	private void updateDelegate(Trade trade) {
		logger.info(ExposedTradeFunction.class +  ":  Initiate Trade Save");
		response = this.tradeCaptureService.updateTrade(trade);
	}


	public void findTrade(){
		//Will need to add UI support Later,using dummy data set as for now
		for(Long tradeId : TradeDataSetGenerator.retriveTradesWithIds()) {
			this.executorService.submit(
					() -> this.findTradeDelegate(tradeId));
		}
	}

	private void findTradeDelegate(Long tradeId) {
		logger.info(ExposedTradeFunction.class +  ":  Initiate Trade Save");
		Trade fetchedTrade= this.tradeCaptureService.findTrade(tradeId);
		logger.info(ExposedTradeFunction.class +"####--Fetched Trade with id: "+ fetchedTrade.getTradeId() +" is : ["  +fetchedTrade.toString()+" ]---####");
	}

	public void fetchTrade(){
		//Will need to add UI support Later,using dummy data set as for now
		for(List<String> fetchCondition : TradeDataSetGenerator.retriveSearchCondition()) {
			this.executorService.submit(
					() -> this.fetchTradesDelegate(fetchCondition.get(0), fetchCondition.get(1)));
		}
	}

	private void fetchTradesDelegate(String fieldId , String filterText) {
		logger.info(ExposedTradeFunction.class +  ":  Initiate Trade Save");
		List<Trade> fetchedTrade= this.tradeCaptureService.fetchTrade(fieldId,filterText);
		for(Trade trades : fetchedTrade) {
			logger.info(ExposedTradeFunction.class +"####--Fetched Trade with id: "+ trades.getTradeId() +" is : ["  +trades.toString()+" ]---####");
		}
	}

}