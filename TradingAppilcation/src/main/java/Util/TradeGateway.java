package Util;

import com.google.inject.ImplementedBy;

import Domain.Trade;
import PersistableEntity.TradePersistable;

@ImplementedBy(TradeGatewayNoImpl.class)
public interface TradeGateway {

	void persist();

	Trade findTradeById(final String tradeId);
}
