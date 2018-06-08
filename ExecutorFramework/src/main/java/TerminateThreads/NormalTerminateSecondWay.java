package TerminateThreads;

//Here we will use the interrupt method 

import java.util.concurrent.TimeUnit;

public class NormalTerminateSecondWay {

	public static void main(String[] args) {
		
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");
		
		LoopTaskF task1 = new LoopTaskF();
		LoopTaskF task2 = new LoopTaskF();
		LoopTaskF task3 = new LoopTaskF();
		
		Thread t1 = new Thread(task1, "My Thread-1");
		t1.start();
		Thread t2 = new Thread(task2, "My Thread-2");
		t2.start();
		Thread t3 = new Thread(task3, "My Thread-3");
		t3.start();
		
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
		
		System.out.println(currentThread + "Main Thread ENDS Here");
		}
	}
