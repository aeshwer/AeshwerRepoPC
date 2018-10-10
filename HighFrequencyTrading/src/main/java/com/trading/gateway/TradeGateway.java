package com.trading.gateway;

import com.google.inject.ImplementedBy;
import com.trading.domain.trade.Trade;

@ImplementedBy(TradeGatewayNoImpl.class)
public interface TradeGateway {

	void persist(Trade trade);
	
/*	void persist(final Trade trade);

	  Trade findTradeById(final String tradeId);

	  List<String> findTradeIdsByCriteria(final SearchCriteria searchCriteria);*/
}
