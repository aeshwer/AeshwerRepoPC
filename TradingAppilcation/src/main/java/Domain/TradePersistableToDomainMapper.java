package Domain;

import com.google.inject.Inject;

import PersistableEntity.TradePersistable;

public class TradePersistableToDomainMapper {
	
	private TradePersistable tradePersistable;

	@Inject
	public TradePersistableToDomainMapper(TradePersistable tradePersistable) {
		this.tradePersistable = tradePersistable;
	}

	public Trade PersistableToDomainMapper() 
	{
		Trade trade = new Trade();
		MapPersistableTrade(trade);
		return trade;
	}

	private void MapPersistableTrade(Trade trade) {
		trade.setId(tradePersistable.getId());
		trade.setBuySellIndicator(tradePersistable.getBuySellIndicator());
		trade.setTradeDate(tradePersistable.getTradeDate());
		trade.setPrice1(tradePersistable.getPrice1());
		trade.setPrice2(tradePersistable.getPrice2());
	}
}
