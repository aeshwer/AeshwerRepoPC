package com.trading.domain.trade;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;

public class Trade {

	private Long tradeId;

	private LocalDate tradeDate;

	private String BuySellIndicator;

	private Double price;

	private Double offset;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="startDate", column=@Column(name="Delivery_Start_Date")),
		@AttributeOverride(name="endDate", column=@Column(name="Delivery_End_Date"))
	})
	private Delivery delivery;

	public Trade() {
		// TODO Auto-generated constructor stub
	}

	public Trade(LocalDate tradeDate,String BuySellIndicator,Double price,Double offset,Delivery delivery) {
		this.tradeDate= tradeDate;
		this.BuySellIndicator= BuySellIndicator;
		this.price= price;
		this.offset= offset;
		this.delivery=delivery;
	}
	
	  public final Long getTradeId() {
	    return this.tradeId;
	  }

	  public final void setTradeId(final Long tradeId) {
	    this.tradeId = tradeId;
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
