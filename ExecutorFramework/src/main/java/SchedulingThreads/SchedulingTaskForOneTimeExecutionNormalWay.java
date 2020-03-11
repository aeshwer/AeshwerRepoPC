package SchedulingThreads;

// NOTE 1 - alwasy make timer thread as deamon so that when app thread  dies , 
//the timer thread also dies, if not this way call the cancel method on time 

//NOTE 2 - try to make timer task as  small as possible , else the subseqeunt task will be hoged(delayed) because of a 
// long running task
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class SchedulingTaskForOneTimeExecutionNormalWay {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

	public static void main(String[] args) {
		String currentThread = Thread.currentThread().getName();
		System.out.println(currentThread + "Main Thread Starts Here");

		Timer timer = new Timer("Timer-Thread", false); // usually make time thread as deamon(if true, nothing will run)
		Date currentTime = new Date();
		Date schdeledTime = TimeUtils.getFutureTime(currentTime, 5000); // calculated the exact time which comes 5
																		// seconds after current time

		System.out.println(currentThread + " Current Time : " + dateFormat.format(currentTime));
		timer.schedule(new ScheduledTaskA(0), schdeledTime);
		System.out.println(
				currentThread + "Task 1 scheduled for runnig at specified time : " + dateFormat.format(schdeledTime));

		// **********************************************************************************//
		// ***********************adding second
		// task****************************************//

		long delayMillis = 10000;
		ScheduledTaskA task2 = new ScheduledTaskA(0);
		timer.schedule(task2, delayMillis);
		System.out.println(currentThread + "Task 2 scheduled for runnig at  : " + delayMillis / 1000
				+ "seconds Initail delay after current time, i.e at : "
				+ dateFormat.format(new Date(task2.scheduledExecutionTime())));

		// **********************************************************************************//
		// ***********************adding third
		// task****************************************//

		long delayMillis2 = 12000;
		ScheduledTaskA task3 = new ScheduledTaskA(0);
		timer.schedule(task3, delayMillis2);
		System.out.println(currentThread + "Task 2 scheduled for runnig at  : " + delayMillis2 / 1000
				+ "seconds Initail delay after current time, i.e at : "
				+ dateFormat.format(new Date(task3.scheduledExecutionTime())));

		// **********************************************************************************//
		// ***********************adding forth
		// task****************************************//
		Date schdeledTime2 = TimeUtils.getFutureTime(currentTime, 30000);
		ScheduledTaskA task4 = new ScheduledTaskA(0);
		timer.schedule(task4, schdeledTime2);
		System.out.println(currentThread + "Task 4 scheduled for runnig at specified time : "
				+ dateFormat.format(new Date(task3.scheduledExecutionTime())));

		task4.cancel();// if u want to cancel task after scheduling it?

		// **********************************************************************************//
		System.out.println(currentThread + "CANCEL TIMER NOW : ");
		timer.cancel(); // use this u have set timer as non deamon thread

		System.out.println(currentThread + "Main Thread ENDS Here");
	}

}
