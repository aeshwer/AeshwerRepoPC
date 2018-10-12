package com.trading.gateway;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;
import com.trading.domain.trade.TradeStatus;
import com.trading.gateway.downstream.HighFrequencyTradeCapturePostOperation;
import com.trading.gateway.repository.TradeRepository;

public class TradePersistServiceImpl implements TradePersistService{
	
	private final TradeRepository tradeRepository;
	
	private final PrePersistProcessingManager prePersistProcessingManager;
	
	  private final HighFrequencyTradeCapturePostOperation highFrequencyTradeCapturePostOperation;

	@Inject
	public TradePersistServiceImpl(final TradeRepository tradeRepository,final PrePersistProcessingManager prePersistProcessingManager,HighFrequencyTradeCapturePostOperation highFrequencyTradeCapturePostOperation) {
		this.tradeRepository = tradeRepository;
		this.prePersistProcessingManager = prePersistProcessingManager;
		this.highFrequencyTradeCapturePostOperation = highFrequencyTradeCapturePostOperation;
	}
	

	@Override
	public void persist(Trade trade) {
	    Trade tradeObject = null;
	    if (null == trade.getTradeId()) {
	    	tradeObject = trade;
	    	prePersistProcessingManager.mapForCreateOperation(tradeObject);
	    } else {
	    	// XXX Update case
	    	final Trade savedOldTrade = this.tradeRepository.findByTradeId(Long.valueOf(trade.getTradeId()));
	    	tradeObject = prePersistProcessingManager.mapForUpdateOperation(tradeObject,savedOldTrade);
	    }
		final Trade persistTrade = this.tradeRepository.persist(tradeObject);
		trade.setTradeId(persistTrade.getTradeId());
		trade.setTradeStatus(persistTrade.getTradeStatus());
		if(trade.getTradeStatus()== TradeStatus.ACCECPTED) 
		{
			highFrequencyTradeCapturePostOperation.perform(trade);
		}
	}
}