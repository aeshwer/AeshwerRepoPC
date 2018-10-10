package com.trading.launcher;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.trading.commons.util.LogManagerUtil;
import com.trading.entryPoint.Function.ExposedTradeFunction;


public class HighFrequencyTradingMain {
	
	private static Injector injector;
	
	private final static Logger logger = LogManagerUtil.getLogger(HighFrequencyTradingMain.class);
	
	public static void main(String[] args) {
		logger.info("***********High Frequency Trading App Starts: "+" ***************");
		injector = Guice.createInjector(new ApplicationModule());
		System.out.println();
		ExposedTradeFunction exposedTradeFunction = injector.getInstance(ExposedTradeFunction.class);
		logger.info("***********Saving some Trades : "+" ***************");
		exposedTradeFunction.updatePhysicalTrade();
	}
}
