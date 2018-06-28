package Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

public class DummyTradeCreator implements ITrade,IEntity{

	private Trade trade;

	@Inject
	public DummyTradeCreator(Trade trade) {
		this.trade = trade;
	}

	public List<Trade> CreatedummyTrade() 
	{
		List<Trade> listOfTrade = new ArrayList<>();
		// assuming these are obtained from USer
		int loop = 5;
		int id = 1;
		while(loop-->0)
		{
			Trade trade = new Trade();
			trade.setId(id++);
			trade.setBuySellIndicator("Buy");
			trade.setPrice1(100);
			trade.setPrice2(200);
			trade.setTradeDate(new Date());
			listOfTrade.add(trade);
		}
		return listOfTrade;
	}

	public int getId() {
		return 0;
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
