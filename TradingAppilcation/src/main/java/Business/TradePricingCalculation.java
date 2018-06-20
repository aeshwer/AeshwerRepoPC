package Business;

import Domain.ITrade;

public class TradePricingCalculation {
	
	private ITrade trade;

	public TradePricingCalculation(ITrade trade) {
		this.trade = trade;
	}
	
	public int CalculateAveragePrice(int price1,int price2) 
	{
		return (price1 + price2)/2;
	}
}
