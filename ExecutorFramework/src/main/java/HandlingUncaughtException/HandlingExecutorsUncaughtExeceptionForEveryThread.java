// use of default handler for executors 
package HandlingUncaughtException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlingExecutorsUncaughtExeceptionForEveryThread {

	public static void main(String[] args) throws Exception {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");
				
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default_Handler"));
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());
		executorService.execute(new ExceptionLeakingTask());

		ExecutorService executorService2 = Executors.newCachedThreadPool();
		executorService2.execute(new ExceptionLeakingTask());
		executorService2.execute(new ExceptionLeakingTask());
		executorService2.execute(new ExceptionLeakingTask());
		
		executorService.shutdown();
		executorService2.shutdown();
		
		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}

