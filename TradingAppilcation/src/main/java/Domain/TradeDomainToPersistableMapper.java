package Domain;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import Business.AbstractPriceGenerator;
import PersistableEntity.TradePersistable;

public class TradeDomainToPersistableMapper {

	private ITrade trade;
	private AbstractPriceGenerator tradePricingCalculation;

	@Inject
	public TradeDomainToPersistableMapper(@Named("Real") ITrade trade,AbstractPriceGenerator tradePricingCalculation) {
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
