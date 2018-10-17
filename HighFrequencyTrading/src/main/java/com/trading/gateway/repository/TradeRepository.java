package com.trading.gateway.repository;

import com.trading.domain.trade.Trade;

public interface TradeRepository {
	Trade persist(Trade term);

	Trade findByTradeId(Long tradeId);

	Trade findTradeByCriteria(String fieldId, String filterText);

}