package com.trading.gateway.repository.transformer;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.Validate;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;
import com.trading.gateway.jpa.persistable.TradePersistable;

public class TradePersistableTransformerImpl implements TradePersistableTransformer{
	
	private SequenceNumberGenerator sequenceNumberGenerator;
	
	@Inject
	public TradePersistableTransformerImpl(SequenceNumberGenerator sequenceNumberGenerator) {
		this.sequenceNumberGenerator = sequenceNumberGenerator;
	}

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
	
	@Override
	public void generateIds(TradePersistable tradePersistable, EntityManager entityManager) {
		Validate.notNull(tradePersistable, "TradePersistable cannot be null.");
		this.sequenceNumberGenerator.generate(entityManager, tradePersistable);
	}
}
