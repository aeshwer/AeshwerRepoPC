package com.trading.gateway.jpa.persistable;

import com.trading.domain.trade.Trade;

public class PersistableTradeEntityModel {
	
	private TradePersistable persistable;
	
	private Trade trade;

	public PersistableTradeEntityModel() {
	}
	
	public TradePersistable getPersistable() {
		return persistable;
	}

	public void setPersistable(TradePersistable persistable) {
		this.persistable = persistable;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	

}
