package com.trading.gateway;

import java.time.LocalDate;
import java.time.Month;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;
import com.trading.domain.trade.TradeStatus;
import com.trading.gateway.downstream.HighFrequencyTradeCapturePostOperationNotifier;
import com.trading.gateway.repository.TradeRepository;

public class TradePersistServiceImpl implements TradePersistService{
	
	private final TradeRepository tradeRepository;
	
	private final PrePersistProcessingManager prePersistProcessingManager;
	
	  private final HighFrequencyTradeCapturePostOperationNotifier highFrequencyTradeCapturePostOperationNotifier;

	@Inject
	public TradePersistServiceImpl(final TradeRepository tradeRepository,final PrePersistProcessingManager prePersistProcessingManager,HighFrequencyTradeCapturePostOperationNotifier highFrequencyTradeCapturePostOperationNotifier) {
		this.tradeRepository = tradeRepository;
		this.prePersistProcessingManager = prePersistProcessingManager;
		this.highFrequencyTradeCapturePostOperationNotifier = highFrequencyTradeCapturePostOperationNotifier;
	}
	

	@Override
	public void persist(Trade trade) {
	    Trade tradeObject = null;
	    if (null == trade.getTradeId()) {
	    	tradeObject = trade;
	    	prePersistProcessingManager.mapForCreateOperation(tradeObject);
	    } else {
	    	// XXX Update case , will add custom logic here later, now it maps nothing
	    	final Trade savedOldTrade = this.tradeRepository.findByTradeId(Long.valueOf(trade.getTradeId()));
	    	tradeObject = prePersistProcessingManager.mapForUpdateOperation(tradeObject,savedOldTrade);
	    	tradeObject=trade;
	    }
		final Trade persistTrade = this.tradeRepository.persist(tradeObject);
		trade.setTradeId(persistTrade.getTradeId());
		trade.setTradeStatus(persistTrade.getTradeStatus());
		if(trade.getTradeStatus()== TradeStatus.ACCECPTED) 
		{
			highFrequencyTradeCapturePostOperationNotifier.perform(trade);
		}
	}

	@Override
	public void copyTrade(Long tradeId) {
		final Trade copyTradeFromDb = this.tradeRepository.findByTradeId(Long.valueOf(tradeId));
		final Trade persistTrade = this.tradeRepository.copy(copyTradeFromDb);
		if(persistTrade.getTradeStatus()== TradeStatus.ACCECPTED) 
		{
			highFrequencyTradeCapturePostOperationNotifier.perform(persistTrade);
		}
	}


	@Override
	public void deleteTrade(Long tradeId) {
		{
			// need to think about update and delete... basically we only notify the downstream and keep the payload mininum. the downstream will
			// have dependency of trade capture and use its API for fetching data from db. we can also make use of caching.
			if(this.tradeRepository.deleteTrade(tradeId)) 
			{
				Trade deletedTrade = new Trade();
				deletedTrade.setTradeId(tradeId);
				deletedTrade.setTradeStatus(TradeStatus.DELETED);
				deletedTrade.setTradeDate(LocalDate.now());
				
				highFrequencyTradeCapturePostOperationNotifier.perform(deletedTrade);}
		}
		
	}
}