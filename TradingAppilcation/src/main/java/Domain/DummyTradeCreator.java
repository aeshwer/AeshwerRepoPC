package Domain;

import java.util.Date;

import com.google.inject.Inject;

public class DummyTradeCreator implements ITrade,IEntity{

	private Trade trade;

	@Inject
	public DummyTradeCreator(Trade trade) {
		this.trade = trade;
	}

	public Trade CreatedummyTrade() 
	{
		// assuming these are obtained from USer
		Trade trade = new Trade();
		trade.setId("1");
		trade.setBuySellIndicator("Buy");
		trade.setPrice1(100);
		trade.setPrice2(200);
		trade.setTradeDate(new Date());
		return trade;
	}

	public String getId() {
		return null;
	}

	public String getBuySellIndicator() {
		return null;
	}

	public Date getTradeDate() {
		return null;
	}

	public int getPrice1() {
		return 0;
	}

	public int getPrice2() {
		return 0;
	}
}
