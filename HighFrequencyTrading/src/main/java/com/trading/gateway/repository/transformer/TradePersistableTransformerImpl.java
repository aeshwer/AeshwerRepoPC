package com.trading.gateway.repository.transformer;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.Validate;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;
import com.trading.domain.trade.TradeStatus;
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
		tradePersistable.setBuySellIndicator(trade.getBuySellIndicator());
		tradePersistable.setDelivery(trade.getDelivery());
		tradePersistable.setOffset(trade.getOffset());
		tradePersistable.setPrice(trade.getPrice());
		tradePersistable.setTradeDate(trade.getTradeDate());
		tradePersistable.setTradeStatus(TradeStatus.ACCECPTED);
		return tradePersistable;
	}
	
	@Override
	public Trade createDomainFromPersistable(TradePersistable tradePersistable) {
		Trade trade= new Trade();
		trade.setTradeId(tradePersistable.getId());
		trade.setBuySellIndicator(tradePersistable.getBuySellIndicator());
		trade.setDelivery(tradePersistable.getDelivery());
		trade.setOffset(tradePersistable.getOffset());
		trade.setPrice(tradePersistable.getPrice());
		trade.setTradeDate(tradePersistable.getTradeDate());
		trade.setTradeStatus(tradePersistable.getTradeStatus());
		return trade;
	}
	
	@Override
	public void generateIds(TradePersistable tradePersistable, Trade trade) {
		Validate.notNull(tradePersistable, "TradePersistable cannot be null.");
		this.sequenceNumberGenerator.generate(trade, tradePersistable);
	}

	@Override
	public void updatePersistable(Trade trade, TradePersistable tradePersistable) {
		tradePersistable.setBuySellIndicator(trade.getBuySellIndicator());
		tradePersistable.setDelivery(trade.getDelivery());
		tradePersistable.setOffset(trade.getOffset());
		tradePersistable.setPrice(trade.getPrice());
		tradePersistable.setTradeDate(trade.getTradeDate());
		tradePersistable.setTradeStatus(trade.getTradeStatus());
	}
}
