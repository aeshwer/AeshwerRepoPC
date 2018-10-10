package com.trading.launcher;

import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.trading.commons.util.LogManagerUtil;
import com.trading.entryPoint.Function.ExposedTradeFunction;


public class HighFrequencyTradingMain {
	
	private static Injector injector;
	
	private final static Logger logger = LogManagerUtil.getLogger(HighFrequencyTradingMain.class);

	public static void main(String[] args) {
		injector = Guice.createInjector(new ApplicationModule());
		ExposedTradeFunction exposedTradeFunction = injector.getInstance(ExposedTradeFunction.class);
		exposedTradeFunction.updatePhysicalTrade();
	}
}
