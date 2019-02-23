package com.trading.gateway;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import com.trading.domain.trade.Trade;


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

	@Override
	public List<Trade> fetchTrade(String fieldId, String filterText) {
		LOG.info("This implementation does nothing.");
		return null;
	}

	@Override
	public void copyTrade(Long tradeId) {
		LOG.info("This implementation does nothing.");
	}

	@Override
	public void deleteTrade(Long tradeId) {
		LOG.info("This implementation does nothing.");
	}
}
