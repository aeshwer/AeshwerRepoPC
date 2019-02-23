package com.trading.gateway;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.trading.domain.trade.Trade;

@ImplementedBy(TradeGatewayNoImpl.class)
public interface TradeGateway {

	void persist(Trade trade);

	Trade findTrade(Long tradeId);

	List<Trade> fetchTrade(String fieldId, String filterText);

	void copyTrade(Long tradeId);

	void deleteTrade(Long tradeId);
}
