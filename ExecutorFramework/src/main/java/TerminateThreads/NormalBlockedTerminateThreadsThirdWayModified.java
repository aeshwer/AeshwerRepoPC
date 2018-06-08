package TerminateThreads;
/*
Terminating Thread when they are blocked... the first 2 example show case where the threads are not blocked.....the best example for blocked case
 is the sleep method... why we need try/catch block....since it can give a Uninterrupted exception if it is interrupted while it is sleeping
 this is  what is demonstrated in this example
 
 see difference between taskG and TaskH
 */

import java.util.concurrent.TimeUnit;

public class NormalBlockedTerminateThreadsThirdWayModified {

	public static void main(String[] args) {

		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");

		LoopTaskG task1 = new LoopTaskG();
		LoopTaskG task2 = new LoopTaskG();
		LoopTaskG task3 = new LoopTaskG();
		LoopTaskH task4 = new LoopTaskH();
		LoopTaskH task5 = new LoopTaskH();

		Thread t1 = new Thread(task1, "My Thread-1");
		t1.start();
		Thread t2 = new Thread(task2, "My Thread-2");
		t2.start();
		Thread t3 = new Thread(task3, "My Thread-3");
		t3.start();
		Thread t4 = new Thread(task4, "My Thread-4");
		t4.start();
		Thread t5 = new Thread(task5, "My Thread-5");
		t5.start();

		try {
			TimeUnit.MILLISECONDS.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("####### [ "+   currentThread + "] Interupting " + t1.getName() +"........");
		t1.interrupt();
		System.out.println("####### [ "+   currentThread + "] Interupting " + t2.getName() +"........");
		t2.interrupt();
		System.out.println("####### [ "+   currentThread + "] Interupting " + t3.getName() +"........");
		t3.interrupt();
		System.out.println("####### [ "+   currentThread + "] Interupting " + t4.getName() +"........");
		t4.interrupt();
		System.out.println("####### [ "+   currentThread + "] Interupting " + t5.getName() +"........");
		t5.interrupt();

		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}
