package Util;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import Domain.Trade;
import PersistableEntity.TradePersistable;

public class TradeGatewayNoImpl implements TradeGateway  {
	private static final Logger LOG = LoggerFactory.logger(TradeGatewayNoImpl.class);

		public Trade findTradeById(int tradeId) {
		 LOG.info("This implementation does nothing.");
		return new Trade();
	}

	@Override
	public void persist(TradePersistable persistable) {
		 LOG.info("This implementation does nothing.");
		
	}

	@Override
	public Trade copyTrade(int tradeId) {
		 LOG.info("This implementation does nothing.");
		 return new Trade();
	}

}
