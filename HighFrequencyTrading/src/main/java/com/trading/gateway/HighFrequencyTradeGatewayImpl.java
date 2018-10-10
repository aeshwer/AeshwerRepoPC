package com.trading.gateway;

import javax.inject.Inject;

import com.trading.domain.trade.Trade;

public class HighFrequencyTradeGatewayImpl  implements TradeGateway{

	private TradePersistService tradePersistService;
	private TradeFetchService tradeFetchService;

	@Inject
	public HighFrequencyTradeGatewayImpl(final TradePersistService tradePersistService,final TradeFetchService tradeFetchService) {
		this.tradePersistService = tradePersistService;
		this.tradeFetchService = tradeFetchService;
	}

	@Inject
	public void persist(Trade trade) {
		this.tradePersistService.persist(trade);
	}


}
