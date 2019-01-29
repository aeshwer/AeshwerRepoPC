package com.trading.services;

import java.util.List;

import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;

public interface TradeService {

	TradeResponse updateTrade(Trade trade);

	Trade findTrade(Long tradeId);

	List<Trade> fetchTrade(String fieldId, String filterText);

	TradeResponse updateTrade(Long tradeId);

	TradeResponse deleteTrade(Long tradeId);
}
