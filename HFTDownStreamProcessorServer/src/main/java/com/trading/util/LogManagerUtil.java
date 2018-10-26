package com.trading.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogManagerUtil  {
	public static Logger logger;

	public LogManagerUtil() {

	}
	public static synchronized <T> Logger getLogger(Class<T> name) {
		if (logger == null) {
			logger =  LogManager.getLogger(name);
		}
		return logger;
	}
}
