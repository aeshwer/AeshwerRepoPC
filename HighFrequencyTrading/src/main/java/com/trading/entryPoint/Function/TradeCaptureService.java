package com.trading.entryPoint.Function;

import java.util.List;

import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;

public interface TradeCaptureService {

	TradeResponse updateTrade(Trade trade);
	
	Trade findTrade(final Long tradeId);

	List<Trade> fetchTrade(String fieldId, String filterText);

	TradeResponse copyTrade(Long tradeId);

	TradeResponse deleteTrade(Long tradeId);

}
