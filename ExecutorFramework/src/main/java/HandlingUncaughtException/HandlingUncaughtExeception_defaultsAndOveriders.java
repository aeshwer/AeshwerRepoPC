// Leaking Exceptions from threads cannot be caught..see proof ...how to solve: Implement Thread.uncaughtExceptionHandler

package HandlingUncaughtException;

public class HandlingUncaughtExeception_defaultsAndOveriders {

	public static void main(String[] args) throws Exception {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");

		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("The_Default_One"));

		Thread t1 = new Thread(new ExceptionLeakingTask(),"MyThread-1");

		Thread t2 = new Thread(new ExceptionLeakingTask(),"MyThread-2");
		t2.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom_Handler_1"));

		Thread t3 = new Thread(new ExceptionLeakingTask(),"MyThread-3");

		Thread t4 = new Thread(new ExceptionLeakingTask(),"MyThread-4");
		t4.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom_Handler_2"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}

