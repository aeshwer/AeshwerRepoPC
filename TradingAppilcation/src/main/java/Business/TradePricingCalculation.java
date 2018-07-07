package Business;

public class TradePricingCalculation implements AbstractPriceGenerator{
	
	public int CalculateAveragePrice(int price1,int price2) 
	{
		return (price1 + price2)/2;
	}
	
}
