package PersistableEntity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import Domain.IPersistableEntity;

@Entity
@Table(name ="XTP_TRADE_DETAIL")
public class TradeDetailsPersistable implements IPersistableEntity{
	
	@Id
	private int detailId;

	private String status;

	private String currency;

	private String trader;
	
	public TradeDetailsPersistable() {
	}
	
	public TradeDetailsPersistable(int detailId,String status,String currency,String trader) {
		this.detailId= detailId;
		this.status= status;
		this.currency= currency;
		this.trader= trader;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}
}
