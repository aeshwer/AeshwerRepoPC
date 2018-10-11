package com.trading.validation;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;

public class TradeValidationServiceImpl implements TradeValidationService{
	
	private TradeResponse response;

	@Inject
	public TradeValidationServiceImpl() {
	}
	
	
	@Override
	public TradeResponse validateTrade(Trade trade) {
		response = new TradeResponse();
		List<TradeValidationError> validationErrors = new ArrayList<>();
		response.setValidationErrors(validationErrors);
		response.setTrade(trade);
		response.setResponseMessage("Valid Trade Fields");
		return response;
	}

}
