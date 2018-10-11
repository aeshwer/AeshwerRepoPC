package com.trading.gateway.jpa.persistable;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trading.domain.trade.Delivery;

@Entity
@Table(name ="HFT_TRADE")
public class TradePersistable {
	
	@Id
	private Long id;

	@Column(name="Trade_Date", nullable=false)
	private LocalDate tradeDate;

	@Column(name="Buy_Sell", nullable=false)
	private String BuySellIndicator;

	@Column(name="Trade_Price", nullable=false)
	private Double price;

	@Column(name="Offset_Price", nullable=true)
	private Double offset;

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
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOffset() {
		return offset;
	}

	public void setOffset(Double offset) {
		this.offset = offset;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
}
