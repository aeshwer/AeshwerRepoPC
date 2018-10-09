package com.trading.gateway;

import com.trading.domain.trade.Trade;

public interface TradeGateway {

	void persist(Trade trade);
	
/*	void persist(final Trade trade);

	  Trade findTradeById(final String tradeId);

	  List<String> findTradeIdsByCriteria(final SearchCriteria searchCriteria);*/
}
