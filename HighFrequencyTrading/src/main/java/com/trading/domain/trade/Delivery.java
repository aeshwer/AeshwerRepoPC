package com.trading.domain.trade;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Delivery {

	LocalDate startDate;

	LocalDate endDate;

	@Column(name="Delivery_Terms", nullable=false)
	String deliveryTerms;

	public Delivery() {
	}

	public Delivery(LocalDate startDate,LocalDate endDate,String deliveryTerms) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.deliveryTerms = deliveryTerms;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

}

