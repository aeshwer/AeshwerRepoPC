package com.trading.validation;

import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;

public interface TradeValidationService {
	
	TradeResponse validateTrade(Trade trade);

}
