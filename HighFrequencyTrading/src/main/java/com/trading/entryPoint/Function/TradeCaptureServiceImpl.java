package com.trading.entryPoint.Function;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;
import com.trading.services.TradeService;

public class TradeCaptureServiceImpl implements TradeCaptureService{
	
	private TradeService tradeService;
	
	@Inject
	public TradeCaptureServiceImpl(final Injector injector) {
		 this.tradeService = injector.getInstance(TradeService.class);
	}

	@Override
	public TradeResponse updateTrade(Trade trade) {
		//Extract Trade from Trade JSON
		 return tradeService.updateTrade(trade);
	}

	@Override
	public Trade findTrade(Long tradeId) {
		return tradeService.findTrade(tradeId);
	}
}
