package com.trading.services;

import javax.inject.Inject;

import com.trading.gateway.TradeGateway;

public class TradeServiceImpl implements TradeService{
	
	private final TradeGateway tradeGateway;

	@Inject
	public TradeServiceImpl(TradeGateway tradeGateway) {
		this.tradeGateway = tradeGateway;
	}

}
