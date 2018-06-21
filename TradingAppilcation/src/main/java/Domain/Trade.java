package Domain;

import java.util.Date;
public class Trade implements ITrade, IEntity{

	private String id;

	private String BuySellIndicator;

	private int price1;

	private int price2;

	private Date tradeDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuySellIndicator() {
		return BuySellIndicator;
	}

	public void setBuySellIndicator(String buySellIndicator) {
		BuySellIndicator = buySellIndicator;
	}

	public int getPrice1() {
		return price1;
	}

	public void setPrice1(int price1) {
		this.price1 = price1;
	}

	public int getPrice2() {
		return price2;
	}

	public void setPrice2(int price2) {
		this.price2 = price2;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	@Override
	public String toString() {
		return "Id : "+this.getId() + "Buy/Sell :  " + this.getBuySellIndicator()+ "Trade Date: " + this.getTradeDate();
	}
}
