package com.trading.gateway.repository.transformer;

import java.util.UUID;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;
import com.trading.gateway.jpa.persistable.TradePersistable;

public class SequenceNumberGenerator {

	@Inject
	public SequenceNumberGenerator() {
	}

	public void generate(Trade trade, TradePersistable tradePersistable) {
		//tradePersistable.setId(UUID.randomUUID().toString());
		//trade.setTradeId(tradePersistable.getId());
	}
}
