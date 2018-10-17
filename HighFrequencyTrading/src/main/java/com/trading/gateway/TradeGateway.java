package com.trading.gateway;

import com.google.inject.ImplementedBy;
import com.trading.domain.trade.Trade;

@ImplementedBy(TradeGatewayNoImpl.class)
public interface TradeGateway {

	void persist(Trade trade);

	Trade findTrade(Long tradeId);

	Trade fetchTrade(String fieldId, String filterText);
	
}
