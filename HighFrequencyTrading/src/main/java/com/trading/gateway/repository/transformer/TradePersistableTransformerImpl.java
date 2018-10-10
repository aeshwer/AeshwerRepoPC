package com.trading.gateway.repository.transformer;

import com.trading.domain.trade.Trade;
import com.trading.gateway.jpa.persistable.TradePersistable;

public class TradePersistableTransformerImpl implements TradePersistableTransformer{

	@Override
	public TradePersistable createPersistable(Trade trade) {
		TradePersistable tradePersistable = new TradePersistable();
		tradePersistable.setId(trade.getTradeId());
		tradePersistable.setBuySellIndicator(trade.getBuySellIndicator());
		tradePersistable.setDelivery(trade.getDelivery());
		tradePersistable.setOffset(trade.getOffset());
		tradePersistable.setPrice(trade.getPrice());
		tradePersistable.setTradeDate(trade.getTradeDate());
		return tradePersistable;
	}
}
