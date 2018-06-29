package Business;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import Domain.ITrade;

public class TradePricingCalculation implements AbstractPriceGenerator{
	
	private ITrade trade;

	@Inject
	public TradePricingCalculation(@Named("Real") ITrade trade) {
		this.trade = trade;
	}
	
	public int CalculateAveragePrice(int price1,int price2) 
	{
		return (price1 + price2)/2;
	}
	
}
