package com.trading.services;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.trading.commons.util.LogManagerUtil;
import com.trading.domain.response.TradeResponse;
import com.trading.domain.trade.Trade;
import com.trading.gateway.TradeGateway;
import com.trading.validation.TradeValidationError;
import com.trading.validation.TradeValidationService;

public class TradeServiceImpl implements TradeService{

	private final TradeGateway tradeGateway;

	private final TradeValidationService validationService; 

	private static Logger logger;

	@Inject
	public TradeServiceImpl(TradeGateway tradeGateway,TradeValidationService validationService) {
		this.tradeGateway = tradeGateway;
		this.validationService = validationService;
		logger = LogManagerUtil.getLogger(TradeServiceImpl.class);
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
		logger.info(TradeServiceImpl.class+ ":  Trade Validated ,Sending for Persisting in Database");
		reponse.setResponseMessage("Trade Validated");
		this.tradeGateway.persist(trade);
		return reponse;
	}

	@Override
	public Trade findTrade(Long tradeId) {
		Validate.notNull(tradeId, "Trade Id should not be null");
		final Trade trade = this.tradeGateway.findTrade(tradeId);
		Validate.notNull(trade, "Trade with Trade Id " + tradeId + "not found.");
		return trade;
	}

	@Override
	public List<Trade> fetchTrade(String fieldId, String filterText) {
		Validate.notNull(fieldId, fieldId + " fieldId should not be null");
		final List<Trade> tradeFetched = this.tradeGateway.fetchTrade(fieldId,filterText);
		return tradeFetched;
	}

	@Override
	public TradeResponse updateTrade(Long tradeId) {
		TradeResponse reponse = new TradeResponse();
		Validate.notNull(tradeId, "Trade Id should not be null");
		this.tradeGateway.copyTrade(tradeId);
		reponse.setResponseMessage("Copying Trade");
		return reponse;
	}

	@Override
	public TradeResponse deleteTrade(Long tradeId) {
		TradeResponse reponse = new TradeResponse();
		Validate.notNull(tradeId, "Trade Id should not be null");
		this.tradeGateway.deleteTrade(tradeId);
		reponse.setResponseMessage("Deleting Trade");
		return reponse;
	}
}
