package DateAndTimeLesson1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeDemo {

	private static void testLegacyDateAPI() {

		System.out.println("\nDate class ... ");
		Date currentDate = new Date();
		System.out.println("currentDate: " + currentDate);

		System.out.println("currentDate in ms: " + currentDate.getTime());

		System.out.println("\nCalendar class ... ");
		Calendar expiryDate = new GregorianCalendar(2017, 05, 30);
		System.out.println("expiryDate Object : " + expiryDate);
		System.out.println("expiryDate Original : " + expiryDate.getTime());
		expiryDate.add(Calendar.MONTH, 8);
		System.out.println("new expiryDate after Update: " + expiryDate.getTime());

		expiryDate.roll(Calendar.MONTH, 11);
		System.out.println("new expiryDate (roll): " + expiryDate.getTime());
		
		System.out.println();
		System.out.println();

		// Time Zone Demo		
		// System.out.println("\nTimeZones ... ");
		String[] timeZones = TimeZone.getAvailableIDs();
		/*for (String timeZone : timeZones) {
		System.out.println(timeZone);
		}*/
		
		// no-arg constructor below ==> default timezone
		Calendar gameStartTime = new GregorianCalendar(TimeZone.getTimeZone("Europe/London")); 
		gameStartTime.set(2017, Calendar.JULY, 03, 9, 00);
		// System.out.println("gameStartTime: " +  gameStartTime);
		System.out.println("gameStartTime.getTime: " +  gameStartTime.getTime());
		System.out.println("London time -- MONTH/DAY at hr:min:sec (AM/PM) -- " + (gameStartTime.get(Calendar.MONTH) + 1) + "/" + gameStartTime.get(Calendar.DAY_OF_MONTH) + " at " + gameStartTime.get(Calendar.HOUR) + ":" + gameStartTime.get(Calendar.MINUTE) + " (" + ((gameStartTime.get(Calendar.AM_PM) == 0) ? "AM" : "PM") + ")");

		gameStartTime.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		System.out.println("Indian time -- MONTH/DAY at hr:min:sec (AM/PM) -- " + (gameStartTime.get(Calendar.MONTH) + 1) + "/" + gameStartTime.get(Calendar.DAY_OF_MONTH) + " at " + gameStartTime.get(Calendar.HOUR) + ":" + gameStartTime.get(Calendar.MINUTE) + " (" + ((gameStartTime.get(Calendar.AM_PM) == 0) ? "AM" : "PM") + ")");

		gameStartTime.setTimeZone(TimeZone.getTimeZone("GMT-08:30"));
		System.out.println("Custome time -- MONTH/DAY at hr:min:sec (AM/PM) -- " + (gameStartTime.get(Calendar.MONTH) + 1) + "/" + gameStartTime.get(Calendar.DAY_OF_MONTH) + " at " + gameStartTime.get(Calendar.HOUR) + ":" + gameStartTime.get(Calendar.MINUTE) + " (" + ((gameStartTime.get(Calendar.AM_PM) == 0) ? "AM" : "PM") + ")");

		// DST: Change Calendar.JANUARY to Calendar.JULY. GMT would be 8 and London would be at 9 (GMT+1)
		// UK observes DST from March to October (British Summer Time)

		// After/Before demonstration
		Calendar gameFinal = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
		gameFinal.set(2017, Calendar.JULY, 16, 9, 00);
		System.out.println("After? " + gameStartTime.after(gameFinal));
		System.out.println("Before? " + gameStartTime.before(gameFinal));
	}



	public static void main(String[] args) {		
		testLegacyDateAPI();
	}
}
