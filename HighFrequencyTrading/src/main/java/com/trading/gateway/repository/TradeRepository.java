package com.trading.gateway.repository;

import java.util.List;

import com.trading.domain.trade.Trade;

public interface TradeRepository {
	Trade persist(Trade term);

	Trade findByTradeId(Long tradeId);

	List<Trade> findTradeByCriteria(String fieldId, String filterText);

	Trade copy(Trade copyTradeFromDb);

	Boolean deleteTrade(Long tradeId);

}