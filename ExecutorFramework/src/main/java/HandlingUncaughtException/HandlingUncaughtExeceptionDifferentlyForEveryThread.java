// Leaking Exceptions from threads cannot be caught..see proof ...how to solve: Implement Thread.uncaughtExceptionHandler

package HandlingUncaughtException;

public class HandlingUncaughtExeceptionDifferentlyForEveryThread {

	public static void main(String[] args) throws Exception {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");
		
		Thread t1 = new Thread(new ExceptionLeakingTask(),"MyThread-1");
		Thread t2 = new Thread(new ExceptionLeakingTask(),"MyThread-2");
		Thread t3 = new Thread(new ExceptionLeakingTask(),"MyThread-3");
		Thread t4 = new Thread(new ExceptionLeakingTask(),"MyThread-4");
		
		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}

