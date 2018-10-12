package com.trading.gateway;

import com.trading.domain.trade.Trade;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;


public class TradeGatewayNoImpl implements TradeGateway {
	private static final Logger LOG = LoggerFactory.logger(TradeGatewayNoImpl.class);

	@Override
	public void persist(Trade trade) {
		 LOG.info("This implementation does nothing.");
	}

	@Override
	public Trade findTrade(Long tradeId) {
		LOG.info("This implementation does nothing.");
		return new Trade();
	}
}
