package com.trading.gateway;


import org.apache.commons.lang3.StringUtils;

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
	    final Trade tradeObject;
	    
	    if (StringUtils.isBlank(trade.getTradeId())) {
	    	tradeObject = trade;
	      //term = this.tradeToTermMapper.mapForCreateOperation(trade);
	    } else {
	    	tradeObject = trade;
	      //final Trade savedTerm = this.tradeRepository.findByTradeId(Long.valueOf(trade.getTradeId()));
	      //term = this.tradeToTermMapper.mapForUpdateOperation(trade, savedTerm);
	    }
	    prePersistProcessingManager.process(tradeObject);
		final Trade persistTerm = this.tradeRepository.persist(tradeObject);
		trade.setTradeId(persistTerm.getTradeId());
		trade.setTradeStatus(TradeStatus.PENDING);
		highFrequencyTradeCapturePostOperation.perform(trade);
	}
}