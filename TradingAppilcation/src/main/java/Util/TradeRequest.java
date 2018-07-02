package Util;

import PersistableEntity.TradePersistable;

public class TradeRequest {

	private TradeRequestType requestType;

	private TradePersistable persistable;
	
	public TradeRequest() {
	}

	public TradeRequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(TradeRequestType requestType) {
		this.requestType = requestType;
	}

	public TradePersistable getPersistable() {
		return persistable;
	}

	public void setPersistable(TradePersistable persistable) {
		this.persistable = persistable;
	}

	public TradeRequest(TradeRequestType requestType , TradePersistable persistable) {
		this.requestType = requestType;
		this.persistable = persistable;
	}
}
