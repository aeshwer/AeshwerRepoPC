// Leaking Exceptions from threads cannot be caught..see proof ...how to solve: Implement Thread.uncaughtExceptionHandler

package HandlingUncaughtException;

public class HandlingUncaughtExeceptionForEveryThreadProblem {

	public static void main(String[] args) throws Exception {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");

		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default_Handler"));
		new Thread(new ExceptionLeakingTask(),"MyThread-1").start();
		new Thread(new ExceptionLeakingTask(),"MyThread-2").start();
		new Thread(new ExceptionLeakingTask(),"MyThread-3").start();
		new Thread(new ExceptionLeakingTask(),"MyThread-4").start();
		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}

