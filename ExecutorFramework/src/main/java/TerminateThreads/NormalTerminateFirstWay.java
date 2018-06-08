package TerminateThreads;

// each task will shutdown in not the same order in which the cancel method is called ,,,this is normal

import java.util.concurrent.TimeUnit;

public class NormalTerminateFirstWay {

	public static void main(String[] args) {
		
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");
		
		LoopTaskE task1 = new LoopTaskE();
		LoopTaskE task2 = new LoopTaskE();
		LoopTaskE task3 = new LoopTaskE();
		
		new Thread(task1, "My Thread-1").start();
		new Thread(task2, "My Thread-2").start();		
		new Thread(task3, "My Thread-3").start();
		
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		task1.cancle();
		task2.cancle();
		task3.cancle();
		
		System.out.println(currentThread + "Main Thread ENDS Here");
		}
	}
