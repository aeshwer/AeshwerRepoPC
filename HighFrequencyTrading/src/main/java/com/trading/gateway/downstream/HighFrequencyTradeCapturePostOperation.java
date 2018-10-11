package com.trading.gateway.downstream;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;

public class HighFrequencyTradeCapturePostOperation {

	@Inject
	public HighFrequencyTradeCapturePostOperation() {

	}

	public void perform(final Trade trade) {
	}

}
