package com.trading.launcher;

import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.trading.util.LogManagerUtil;


public class HighFrequencyTradingMain {
	
	private static Injector injector;
	
	final static Logger logger = LogManagerUtil.getLogger(HighFrequencyTradingMain.class);

	public static void main(String[] args) {
		injector = Guice.createInjector(new ApplicationModule());
			
	}
}
