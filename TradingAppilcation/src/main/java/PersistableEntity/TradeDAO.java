package PersistableEntity;

import Domain.IEntity;

public class TradeDAO extends GenericDAOManagerEntity{

	private TradePersistable persistable;


	public TradeDAO(TradePersistable persistable) {
		this.persistable = persistable;
	}
	
	public void PeristTrade() {
		super.Perist(persistable);
	}
}
