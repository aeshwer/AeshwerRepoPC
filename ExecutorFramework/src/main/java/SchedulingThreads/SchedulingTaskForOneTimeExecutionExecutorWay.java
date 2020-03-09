package SchedulingThreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SchedulingTaskForOneTimeExecutionExecutorWay {

	public static void main(String[] args) {
		String currentThread = Thread.currentThread().getName();
		System.out.println(currentThread + "Main Thread Starts Here");

		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		
		
		
		System.out.println(currentThread + "Main Thread ENDS Here");
	}

}
