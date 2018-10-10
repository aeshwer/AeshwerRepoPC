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
		dummyTradeList.add(new Trade(LocalDate.of(2017, Month.JUNE, 29),"Sell",100d,57d,new Delivery(LocalDate.of(2017, Month.JUNE, 29),LocalDate.of(2018, Month.JUNE, 29),"Direct Money Transfer")));
		dummyTradeList.add(new Trade(LocalDate.of(2017, Month.FEBRUARY, 10),"Sell",102d,52d,new Delivery(LocalDate.of(2017, Month.FEBRUARY, 29),LocalDate.of(2018, Month.JUNE, 29),"IMPS")));
		dummyTradeList.add(new Trade(LocalDate.of(2017, Month.JULY, 16),"Sell",122d,55d,new Delivery(LocalDate.of(2017, Month.JULY, 29),LocalDate.of(2018, Month.JUNE, 29),"NEFT")));
		dummyTradeList.add(new Trade(LocalDate.of(2017, Month.DECEMBER, 14),"Sell",130d,51d,new Delivery(LocalDate.of(2017, Month.DECEMBER, 29),LocalDate.of(2019, Month.JUNE, 29),"Broker Infused Transfered")));
		return dummyTradeList;
	} 
}
