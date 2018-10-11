package com.trading.gateway;


import com.google.inject.Inject;
import com.trading.domain.trade.Trade;
import com.trading.gateway.repository.TradeRepository;

public class TradePersistServiceImpl implements TradePersistService{
	
	private final TradeRepository tradeRepository;
	
	private final PrePersistProcessingManager prePersistProcessingManager;

	@Inject
	public TradePersistServiceImpl(final TradeRepository tradeRepository,final PrePersistProcessingManager prePersistProcessingManager) {
		this.tradeRepository = tradeRepository;
		this.prePersistProcessingManager = prePersistProcessingManager;
	}
	

	@Override
	public void persist(Trade trade) {
	    final Trade tradeObject;
	    if (trade.getTradeId() != null) {
	    	tradeObject = trade;
	      //term = this.tradeToTermMapper.mapForCreateOperation(trade);
	    } else {
	    	tradeObject = trade;
	      //final Trade savedTerm = this.tradeRepository.findByTradeId(Long.valueOf(trade.getTradeId()));
	      //term = this.tradeToTermMapper.mapForUpdateOperation(trade, savedTerm);
	    }
	    prePersistProcessingManager.process(tradeObject);
		final Trade persistTerm = this.tradeRepository.persist(tradeObject);
	}
}
