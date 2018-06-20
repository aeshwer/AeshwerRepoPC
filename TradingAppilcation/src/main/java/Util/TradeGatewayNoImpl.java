package Util;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import Domain.Trade;

public class TradeGatewayNoImpl implements TradeGateway  {
	private static final Logger LOG = LoggerFactory.logger(TradeGatewayNoImpl.class);

	public void persist() {
		 LOG.info("This implementation does nothing.");
	}

	public Trade findTradeById(String tradeId) {
		 LOG.info("This implementation does nothing.");
		return new Trade();
	}

}
