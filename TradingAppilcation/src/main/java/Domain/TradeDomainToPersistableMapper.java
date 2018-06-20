package Domain;

import com.google.inject.Inject;

import Business.TradePricingCalculation;
import PersistableEntity.TradePersistable;

public class TradeDomainToPersistableMapper {

	private ITrade trade;
	private TradePricingCalculation tradePricingCalculation;

	@Inject
	public TradeDomainToPersistableMapper(ITrade trade,TradePricingCalculation tradePricingCalculation) {
		this.trade = trade;
		this.tradePricingCalculation = tradePricingCalculation;
	}
	
	public TradePersistable DomainToPersistableMapper() 
	{
		TradePersistable persitableTrade = new TradePersistable();
		MapDomainTrade(persitableTrade);
		persitableTrade.setAveragePrice(tradePricingCalculation.CalculateAveragePrice(trade.getPrice1(), trade.getPrice2()));
		return persitableTrade;
	}

	private void MapDomainTrade(TradePersistable persitableTrade) {
		persitableTrade.setId(trade.getId());
		persitableTrade.setBuySellIndicator(trade.getBuySellIndicator());
		persitableTrade.setTradeDate(trade.getTradeDate());
		persitableTrade.setPrice1(trade.getPrice1());
		persitableTrade.setPrice2(trade.getPrice2());
	}
}
