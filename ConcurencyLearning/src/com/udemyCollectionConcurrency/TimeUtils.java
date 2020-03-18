package com.udemyCollectionConcurrency;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {


	TimeUtils() {
	}

	public static Date getFutureTime(Date initialTime, long millisToAdd) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(initialTime.getTime() + millisToAdd);
		return cal.getTime();
	}

	

}
