package com.trading.gateway.repository.transformer;

import com.trading.domain.trade.Trade;
import com.trading.gateway.jpa.persistable.TradePersistable;

public interface TradePersistableTransformer {
	
	  TradePersistable createPersistable(final Trade trade);

}
