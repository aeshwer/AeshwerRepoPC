package com.trading.gateway;

import com.trading.domain.trade.Trade;

public class HighFrequencyTradeGatewayImpl  implements TradeGateway{

	private TradePersistService tradePersistService;
	private TradeFetchService tradeFetchService;
	
	public void persist(Trade trade) {
		this.tradePersistService.persist(trade);
	}


}
