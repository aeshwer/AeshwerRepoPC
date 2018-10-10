package com.trading.entryPoint.Function;

import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.trading.DummyDataSetGenerator.TradeDataSetGenerator;
import com.trading.commons.util.LogManagerUtil;
import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;
import com.trading.services.TradeServiceImpl;

public class ExposedTradeFunction {

	private static final String UPDATE_TRADE = "UpdateTrade";
	private static final String VALIDATE_TRADE = "PhysicalTrade";	
	private static final String FETCH_TRADES = "FetchTrades";
	private static final String FIND_TRADE = "FindTrade";
	private static final String COPY_TRADE = "CopyTrade";
	private static final String USER = "User";
	private static final String CALLER = "Caller";

	private TradeCaptureService tradeCaptureService;
	private ExecutorService executorService;
	private TradeResponse response;
	private static Logger logger;

	@Inject
	public ExposedTradeFunction(final TradeCaptureService tradeCaptureService,final ExecutorService executorService) {
		this.tradeCaptureService = tradeCaptureService;
		this.executorService = executorService;
		this.logger = LogManagerUtil.getLogger(ExposedTradeFunction.class);
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
