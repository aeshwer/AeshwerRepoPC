package com.trading.gateway;

import com.trading.domain.trade.Trade;

public interface TradePersistService {

	void persist(Trade trade);
/*	  Trade findTradeById(final String tradeId);

	  List<String> findTradeIdsByCriteria(final SearchCriteria searchCriteria);*/
}
