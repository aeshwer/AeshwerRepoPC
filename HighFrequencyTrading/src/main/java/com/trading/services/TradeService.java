package com.trading.services;

import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;

public interface TradeService {

	TradeResponse updateTrade(Trade trade);

	Trade findTrade(Long tradeId);
}
