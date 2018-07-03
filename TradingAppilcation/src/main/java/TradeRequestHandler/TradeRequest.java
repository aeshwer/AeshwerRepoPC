package TradeRequestHandler;

import Domain.IPersistableEntity;
import PersistableEntity.TradePersistable;

public class TradeRequest {

	private TradeRequestType requestType;

	private IPersistableEntity persistable;
	
	public TradeRequest() {
	}

	public TradeRequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(TradeRequestType requestType) {
		this.requestType = requestType;
	}

	public IPersistableEntity getPersistable() {
		return persistable;
	}

	public void setPersistable(IPersistableEntity persistable) {
		this.persistable = persistable;
	}

	public TradeRequest(TradeRequestType requestType , IPersistableEntity persistable) {
		this.requestType = requestType;
		this.persistable = persistable;
	}
}
