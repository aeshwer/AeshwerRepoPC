package com.trading.services;

import com.trading.domain.trade.Trade;

public interface TradeService {

	void updateTrade(Trade trade);
/*
	  TradeResponse updatePhysicalTrade();

	  TradeResponse validatePhysicalTrade();

	  Trade fetchTrade(final String tradeId);*/
}
