package com.trading.gateway;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;

public class PrePersistProcessingManager {
	

	@Inject
	public PrePersistProcessingManager() {
	}


	void mapForCreateOperation(final Trade trade) {
	}

	Trade mapForUpdateOperation(final Trade tradeObject,final Trade savedOldTrade) {
		return tradeObject;
	}
}
