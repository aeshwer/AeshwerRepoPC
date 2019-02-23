package com.trading.gateway;

import com.trading.domain.trade.Trade;

public interface TradePersistService {

	void persist(Trade trade);

	void copyTrade(Long tradeId);

	void deleteTrade(Long tradeId);
}
