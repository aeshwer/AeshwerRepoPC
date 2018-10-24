package com.trading.gateway.downstream;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;

public class HighFrequencyTradeCapturePostOperationNotifier {

	@Inject
	public HighFrequencyTradeCapturePostOperationNotifier() {

	}

	public void perform(final Trade trade) {
	}

}
