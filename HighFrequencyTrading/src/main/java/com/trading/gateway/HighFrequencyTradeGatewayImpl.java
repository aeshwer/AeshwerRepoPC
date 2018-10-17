package com.trading.gateway;


import com.google.inject.Inject;
import com.trading.domain.trade.Trade;

public class HighFrequencyTradeGatewayImpl  implements TradeGateway{

	private TradePersistService tradePersistService;
	private TradeFetchService tradeFetchService;

	@Inject
	public HighFrequencyTradeGatewayImpl(final TradePersistService tradePersistService,final TradeFetchService tradeFetchService) {
		this.tradePersistService = tradePersistService;
		this.tradeFetchService = tradeFetchService;
	}

	public void persist(Trade trade) {
		this.tradePersistService.persist(trade);
	}

	@Override
	public Trade findTrade(Long tradeId) {
		return tradeFetchService.findTrade(tradeId);
	}

	@Override
	public Trade fetchTrade(String fieldId, String filterText) {
		return tradeFetchService.fetchTrade(fieldId,filterText);
	}
}
