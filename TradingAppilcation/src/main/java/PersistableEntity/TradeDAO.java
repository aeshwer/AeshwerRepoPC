package PersistableEntity;

import Domain.Trade;
import Util.TradeGateway;

public class TradeDAO extends GenericDAOManagerEntity implements TradeGateway{

	private TradePersistable persistable;

	public TradeDAO(TradePersistable persistable) {
		this.persistable = persistable;
	}

	public void persist() {
		super.Perist(persistable);		
	}

	public Trade findTradeById(String tradeId) {
		return null;
	}
	

}
