package com.trading.services;

import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;

public interface TradeService {

	TradeResponse updateTrade(Trade trade);
/*
	  TradeResponse updatePhysicalTrade();

	  TradeResponse validatePhysicalTrade();

	  Trade fetchTrade(final String tradeId);*/
}
