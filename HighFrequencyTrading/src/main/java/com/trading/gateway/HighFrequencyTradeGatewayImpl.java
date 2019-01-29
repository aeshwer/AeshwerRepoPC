package com.trading.gateway;


import java.util.List;

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
	public List<Trade> fetchTrade(String fieldId, String filterText) {
		return tradeFetchService.fetchTrade(fieldId,filterText);
	}

	@Override
	public void copyTrade(Long tradeId) {
		this.tradePersistService.copyTrade(tradeId);
	}

	@Override
	public void deleteTrade(Long tradeId) {
		this.tradePersistService.deleteTrade(tradeId);
	}
}
