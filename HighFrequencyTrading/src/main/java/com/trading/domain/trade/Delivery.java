package com.trading.domain.trade;

import java.time.LocalDate;

public class Delivery {
	
	LocalDate startDate;
	
	LocalDate endDate;
	
	String deliveryTerms;
	
	public Delivery() {
		// TODO Auto-generated constructor stub
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

