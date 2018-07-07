package WaitingForThreadToComplete;

import DaemonThread.LoopTaskD;

public class JoiningThreads {

	public static void main(String[] args) throws InterruptedException {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");
		
		Thread t1 = new Thread(new LoopTaskD(100),"My-Thread-1");
		Thread t2 = new Thread(new LoopTaskD(200),"My-Thread-2");
		Thread t3 = new Thread(new LoopTaskD(300),"My-Thread-3");
		Thread t4 = new Thread(new LoopTaskD(400),"My-Thread-4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		t1.join();
		System.out.println("["+ currentThread + "] '" + currentThread + "'joined '"+t1.getName()+ "");
		t2.join();
		System.out.println("["+ currentThread + "] '" + currentThread + "'joined '"+t2.getName()+ "");
		t3.join();
		System.out.println("["+ currentThread + "] '" + currentThread + "'joined '"+t3.getName()+ "");
		t4.join();
		System.out.println("["+ currentThread + "] '" + currentThread + "'joined '"+t4.getName()+ "");
		
		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}

