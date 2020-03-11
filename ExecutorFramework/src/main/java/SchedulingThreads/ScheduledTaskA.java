package SchedulingThreads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskA extends TimerTask {

	private long sleepTime;

	private static int count = 0;
	private int instanceNumber = 0;
	private String taskId;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

	public ScheduledTaskA(long sleepTime) {
		this.sleepTime = sleepTime;

		this.instanceNumber = ++count;
		this.taskId = "ScheduledTaskA--" + instanceNumber;
	}

	public void run() {
		// Observe here
		Date StartTime = new Date();
		Date scheduledForRunningTime = new Date(super.scheduledExecutionTime());

		String currentThread = Thread.currentThread().getName();

		System.out.println("####### [" + currentThread + "] <" + taskId + "> SCHEDULED TO RUN AT : "
				+ dateFormat.format(scheduledForRunningTime) + ", ACTUALLY STARTED : + " + dateFormat.format(StartTime)
				+ "###############");
		System.out.println("[" + currentThread + "] <" + taskId + "> Sleeping for" + sleepTime + " milies");

		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("####### [" + currentThread + ",   ] <" + taskId + "> FINSHED AT :" + dateFormat.format(new Date())+ "#####");

	}

}
