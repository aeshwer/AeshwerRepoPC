package com.trading.gateway;

import com.trading.domain.trade.Trade;

public interface TradeFetchService {
	
	  Trade findTrade(final Long tradeId);
}
