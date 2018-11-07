package com.trading.gateway.jpa.persistable;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trading.domain.trade.Delivery;
import com.trading.domain.trade.TradeStatus;

@Entity
@Table(name ="HFT_TRADE")
public class TradePersistable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Trade_Status")
	private TradeStatus tradeStatus;

	@Column(name="Trade_Date", nullable=false)
	private LocalDate tradeDate;

	@Column(name="Buy_Sell", nullable=false)
	private String BuySellIndicator;

	@Column(name="Trade_Price", nullable=false)
	private Double tradePrice;

	@Column(name="Offset_Price", nullable=true)
	private Double offsetPrice;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="startDate", column=@Column(name="Delivery_Start_Date")),
		@AttributeOverride(name="endDate", column=@Column(name="Delivery_End_Date"))
	})
	private Delivery delivery;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getBuySellIndicator() {
		return BuySellIndicator;
	}

	public void setBuySellIndicator(String buySellIndicator) {
		BuySellIndicator = buySellIndicator;
	}

	public Double getPrice() {
		return tradePrice;
	}

	public void setPrice(Double price) {
		this.tradePrice = price;
	}

	public Double getOffset() {
		return offsetPrice;
	}

	public void setOffset(Double offsetPrice) {
		this.offsetPrice = offsetPrice;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
}
