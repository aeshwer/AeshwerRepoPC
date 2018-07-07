// Leaking Exceptions from threads cannot be caught..see proof ...how to solve: Implement Thread.uncaughtExceptionHandler

package HandlingUncaughtException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorsUncaughtExeception_defaultsAndOveriders {

	public static void main(String[] args) throws Exception {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");

		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default_Handler"));

		ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandlingAlternators());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());

		executorService.shutdown();

		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}

