package com.trading.gateway.repository.transformer;

import com.trading.domain.trade.Trade;
import com.trading.gateway.jpa.persistable.TradePersistable;

public interface TradePersistableTransformer {

	TradePersistable createPersistable(final Trade trade);

	Trade createDomainFromPersistable(final TradePersistable  tradePersistable );

	void generateIds(TradePersistable tradePersistable, Trade trade);

	void updatePersistable(Trade trade, TradePersistable tradePersistable);

}
