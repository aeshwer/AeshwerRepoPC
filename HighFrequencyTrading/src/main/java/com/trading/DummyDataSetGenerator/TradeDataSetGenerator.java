package com.trading.DummyDataSetGenerator;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.trading.domain.trade.Delivery;
import com.trading.domain.trade.Trade;

public class TradeDataSetGenerator {

	public static List<Trade> retriveDummyTradesFeeder()
	{
		List<Trade> dummyTradeList = new ArrayList<>();
		dummyTradeList.add(new Trade(LocalDate.of(2017, Month.JUNE, 29),"Sell",100d,57d,new Delivery()));
		dummyTradeList.add(new Trade(LocalDate.of(2017, Month.FEBRUARY, 10),"Sell",102d,52d,new Delivery()));
		dummyTradeList.add(new Trade(LocalDate.of(2017, Month.JULY, 16),"Sell",122d,55d,new Delivery()));
		dummyTradeList.add(new Trade(LocalDate.of(2017, Month.DECEMBER, 14),"Sell",130d,51d,new Delivery()));
		return dummyTradeList;
	} 
}
