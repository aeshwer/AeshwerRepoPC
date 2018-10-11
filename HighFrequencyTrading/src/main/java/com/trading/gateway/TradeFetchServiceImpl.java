package com.trading.gateway;


import com.google.inject.Inject;
import com.trading.gateway.repository.TradeRepository;

public class TradeFetchServiceImpl implements TradeFetchService {

	private final TradeRepository tradeRepository;

	private final PrePersistProcessingManager prePersistProcessingManager;

	@Inject
	public TradeFetchServiceImpl(final TradeRepository tradeRepository,final PrePersistProcessingManager prePersistProcessingManager) {
		this.tradeRepository = tradeRepository;
		this.prePersistProcessingManager = prePersistProcessingManager;
	}

}
