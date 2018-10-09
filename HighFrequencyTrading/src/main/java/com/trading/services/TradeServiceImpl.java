package com.trading.services;

import javax.inject.Inject;

import com.trading.domain.trade.Trade;
import com.trading.gateway.TradeGateway;

public class TradeServiceImpl implements TradeService{
	
	private final TradeGateway tradeGateway;

	@Inject
	public TradeServiceImpl(TradeGateway tradeGateway) {
		this.tradeGateway = tradeGateway;
	}

	@Override
	public void updateTrade(Trade trade) {
		//Add validations
		  this.tradeGateway.persist(trade);
	}

}
