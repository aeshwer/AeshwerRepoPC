package com.trading.entryPoint.Function;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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

	public void updatePhysicalTrade(){
		//Will need to add UI support Later,using dummy data set as for now
		for(Trade trade : TradeDataSetGenerator.retriveDummyTradesFeeder()) {
		this.executorService.submit(
				() -> this.UpdateTradeDelegate(trade));
		}
	}

	private void UpdateTradeDelegate(Trade trade) {
		logger.info("Initiate Trade Save"+ ExposedTradeFunction.class);
		response = this.tradeCaptureService.updateTrade(trade);
	}
}
