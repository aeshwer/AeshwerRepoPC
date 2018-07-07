package Util;

import com.google.inject.ImplementedBy;

import Domain.IPersistableEntity;
import Domain.Trade;

@ImplementedBy(TradeGatewayNoImpl.class)
public interface TradeGateway {

	void persist(final IPersistableEntity iPersistableEntity);

	Trade findTradeById(final int tradeId);
	
	Trade copyTrade(final int tradeId);
}
