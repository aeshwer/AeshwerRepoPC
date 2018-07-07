// Leaking Exceptions from threads cannot be caught..see proof ...how to solve: Implement Thread.uncaughtExceptionHandler

package HandlingUncaughtException;

public class HandlingUncaughtExeceptionDifferentlyForEveryThread {

	public static void main(String[] args) throws Exception {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");
				
		Thread t1 = new Thread(new ExceptionLeakingTask(),"MyThread-1");
		t1.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		Thread t2 = new Thread(new ExceptionLeakingTask(),"MyThread-2");
		t2.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		Thread t3 = new Thread(new ExceptionLeakingTask(),"MyThread-3");
		t3.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		Thread t4 = new Thread(new ExceptionLeakingTask(),"MyThread-4");
		t4.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}

