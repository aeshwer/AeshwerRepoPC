package com.trading.validation;

import javax.inject.Inject;

import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;

public class TradeValidationServiceImpl implements TradeValidationService{
	
	@Inject
	public TradeValidationServiceImpl() {
	}
	

	@Override
	public TradeResponse validateTrade(Trade trade) {
		return new TradeResponse();
	}

}
