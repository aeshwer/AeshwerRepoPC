package com.trading.services;

import java.util.List;

import javax.inject.Inject;
import javax.swing.text.html.Option;

import org.apache.commons.lang3.Validate;

import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;
import com.trading.gateway.TradeGateway;
import com.trading.validation.TradeValidationError;
import com.trading.validation.TradeValidationService;

public class TradeServiceImpl implements TradeService{
	
	private final TradeGateway tradeGateway;
	
	private final TradeValidationService validationService; 

	@Inject
	public TradeServiceImpl(TradeGateway tradeGateway,TradeValidationService validationService) {
		this.tradeGateway = tradeGateway;
		this.validationService = validationService;
	}

	@Override
	public TradeResponse updateTrade(Trade trade) {
		//Add validations
		Validate.notNull(trade, "Trade instance should not be null");
		TradeResponse reponse = validationService.validateTrade(trade);
		List<TradeValidationError> errorList = reponse.getValidationErrors();
		for(TradeValidationError  error: errorList) 
		{	
			if(error.getFieldStatus())
			{
				reponse.setResponseMessage(error.getErrorMessageKey());
				return reponse;
			}
		}  
		this.tradeGateway.persist(trade);
		reponse.setResponseMessage("Send to Persist");
		return reponse;
	}
}
