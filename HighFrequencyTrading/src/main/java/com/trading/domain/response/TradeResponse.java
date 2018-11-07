package com.trading.domain.response;

import java.util.List;

import com.google.common.base.Optional;
import com.trading.domain.trade.Trade;
import com.trading.validation.TradeValidationError;

public class TradeResponse {

	private Trade trade;

	private List<TradeValidationError> validationErrors;
	
	private String responseMessage;

	public TradeResponse() {
	}

	public TradeResponse(Trade trade, List<TradeValidationError> validationErrors) {
		this.trade = trade;
		this.validationErrors = validationErrors;
	}

	public Trade getTrade() {
		return this.trade;
	}

	public void setTrade(final Trade trade) {
		this.trade = trade;
	}

	public List<TradeValidationError> getValidationErrors() {
		return this.validationErrors;
	}

	public void setValidationErrors(final List<TradeValidationError> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}