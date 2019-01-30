package com.trading.launcher;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.trading.commons.util.LogManagerUtil;
import com.trading.entryPoint.Function.ExposedTradeFunction;

public class HighFrequencyTradingMain {

	private static Injector injector;

	private final static Logger logger = LogManagerUtil.getLogger(HighFrequencyTradingMain.class);

	public static void main(String[] args) throws InterruptedException {

		logger.info("***********High Frequency Trading App Starts: " + " ***************");
		injector = Guice.createInjector(new ApplicationModule());
		System.out.println();
		ExposedTradeFunction exposedTradeFunction = injector.getInstance(ExposedTradeFunction.class);
		logger.info("***********Saving some Trades : " + " ***************");
		exposedTradeFunction.saveTrade();
		logger.info("***********Updating some Trades : " + " ***************");
		exposedTradeFunction.updateTrade();
		logger.info("***********Fetching some Trades by id: " + " ***************");
		TimeUnit.MILLISECONDS.sleep(3000);// ensuring all trades are persisted before we fetch them
		exposedTradeFunction.findTrade();
		logger.info("***********Fetching some Trades by Search Condition: " + " ***************");
		exposedTradeFunction.fetchTrade();
		logger.info("***********Copy some Trades by using TradeId: " + " ***************");
		exposedTradeFunction.copyTrade();
		TimeUnit.MILLISECONDS.sleep(3000);// ensuring all trades are persisted before we delete them
		logger.info("***********Delet some Trades by using TradeId: " + " ***************");
		exposedTradeFunction.deleteTrade();
	}
}
