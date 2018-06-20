package TradingAppilcation.TradingAppilcation;

import Business.TradePricingCalculation;
import Domain.DummyTradeCreator;
import Domain.Trade;
import Domain.TradeDomainToPersistableMapper;
import PersistableEntity.TradeDAO;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		DummyTradeCreator dummyTrade = new DummyTradeCreator(new Trade());
		
		TradePricingCalculation tradePricingCalculation = new TradePricingCalculation(dummyTrade.CreatedummyTrade());

		TradeDomainToPersistableMapper mapper = new TradeDomainToPersistableMapper(dummyTrade.CreatedummyTrade(), tradePricingCalculation);
		TradeDAO dao = new TradeDAO(mapper.DomainToPersistableMapper());
		dao.PeristTrade();

	}
}
