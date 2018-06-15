package ExtraOnMultiThreadingfWorld;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

//ATOMIC VARIABLES 
public class Example1 {

	// making total volatile wont work as it only guaranty visibility and is not sufficient  when more than 1 thread do write operation
	private static int total = 0;
	private static int countT1 = 0;
	private static int countT2 = 0;
	private boolean run = true;
	// private  static Object lock =  new Object();   solution 1
	AtomicInteger total2 = new AtomicInteger(0);  //  solution 2

	private Runnable t1 = new Runnable() {
		public void run() {
			while (run) {

				/*// solution 1
				 * synchronized (lock) {    we can sync on (Example.this) >> intance level lock  ,,, don't use (Example.class) >> class level lock ///also (this) wont work as it referes to annoynmus runnanble class here
					total++;
				}*/
				total2.getAndIncrement();
				total++;
				countT1++;
				System.out.println("Hello #" + countT1 + " from Thread 1! Total hello: " + total);
			}
		}
	};

	private Runnable t2 = new Runnable() {
		public void run() {
			while (run) {
				/*// solution 1
				 *synchronized (lock) {
					total++;
				}*/
				total2.getAndIncrement();
				total++;
				countT2++;
				System.out.println("Hello #" + countT2 + " from Thread 2! Total hello: " + total);
			}
		}
	};

	//Constructor
	public Example1() 
	{
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		newCachedThreadPool.execute(t1);
		newCachedThreadPool.execute(t2);
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException ex) {
			Logger.getLogger(Example1.class.getName()).log(Level.SEVERE, null, ex);
		}

		run = false;

		try {
			Thread.sleep(500);
		}
		catch (InterruptedException ex) {
			Logger.getLogger(Example1.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(countT1 + countT2 + " == " + total);
		//VIA ATOMIC
		System.out.println("VAI ATOMIC  = "+ (countT1 + countT2) + " == " + total2);
	}


	public static void main(String[] args) {
		new Example1(); 
	}
}
