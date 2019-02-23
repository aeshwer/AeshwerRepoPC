package com.trading.DummyDataSetGenerator;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.trading.domain.trade.Delivery;
import com.trading.domain.trade.Trade;
import com.trading.domain.trade.TradeConstant;
import com.trading.domain.trade.TradeStatus;

public class TradeDataSetGenerator {

	public static List<Trade> retriveDummyTradesFeeder()
	{
		List<Trade> dummyTradeList = new ArrayList<>();
		dummyTradeList.add(new Trade(TradeStatus.DRAFT,LocalDate.of(2017, Month.JUNE, 29),"Buy",100d,57d,new Delivery(LocalDate.of(2017, Month.JUNE, 29),LocalDate.of(2018, Month.JUNE, 29),"Direct Money Transfer")));
		dummyTradeList.add(new Trade(TradeStatus.DRAFT,LocalDate.of(2017, Month.FEBRUARY, 10),"Buy",102d,52d,new Delivery(LocalDate.of(2017, Month.FEBRUARY, 19),LocalDate.of(2018, Month.JUNE, 19),"IMPS")));
		dummyTradeList.add(new Trade(TradeStatus.DRAFT,LocalDate.of(2017, Month.JULY, 16),"Sell",122d,55d,new Delivery(LocalDate.of(2017, Month.JULY, 29),LocalDate.of(2018, Month.JUNE, 29),"NEFT")));
		//dummyTradeList.add(new Trade(TradeStatus.DRAFT,LocalDate.of(2017, Month.DECEMBER, 14),"Sell",130d,51d,new Delivery(LocalDate.of(2017, Month.DECEMBER, 29),LocalDate.of(2019, Month.JUNE, 29),"Broker Infused Transfered")));
		return dummyTradeList;
	}
	
	public static List<Trade> retriveDummyTradesForUpdateOperation()
	{
		List<Trade> dummyTradeListForUpdate = new ArrayList<>();
		dummyTradeListForUpdate.add(new Trade(1L,TradeStatus.DRAFT,LocalDate.of(2017, Month.JULY, 16),"Sell",122d,55d,new Delivery(LocalDate.of(2017, Month.JULY, 29),LocalDate.of(2018, Month.JUNE, 29),"NEFT")));
		return dummyTradeListForUpdate;
	} 
	
	
	public static List<Long> retriveTradesWithIds()
	{
		List<Long> dummyTradeId = new ArrayList<>();
		dummyTradeId.add(1L);
		dummyTradeId.add(2L);
		return dummyTradeId;
	} 
	
	public static List<List<String>> retriveSearchCondition()
	{
		List<List<String>> dummySearchList = new ArrayList<>();
		List<String> seacrhCriteria1 = new ArrayList<>();
		seacrhCriteria1.add(TradeConstant.BUY_SELL);
		seacrhCriteria1.add("Buy");
		dummySearchList.add(seacrhCriteria1);
		return dummySearchList;
	}
	
	public static List<Long> retriveTradesIdsForCopyOperation()
	{
		List<Long> dummyTradeIdForCopy = new ArrayList<>();
		dummyTradeIdForCopy.add(1L);
		dummyTradeIdForCopy.add(2L);
		return dummyTradeIdForCopy;
	} 
	
	public static List<Long> retriveTradesIdsForDeleteOperation()
	{
		List<Long> dummyTradeIdForDelete = new ArrayList<>();
		dummyTradeIdForDelete.add(1L);
		return dummyTradeIdForDelete;
	}
}

