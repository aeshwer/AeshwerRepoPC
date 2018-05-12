/*
 *Default name for executor thread is Pool n Thread m  so on. where n and m start from 1
 */
package namingTheThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class NamingExecutorThread {

	public static void main(String[] args) {
		
	String currentThread = Thread.currentThread().getName(); 
		
		System.out.println(" <"+ currentThread + " >"+ "Main Thread Starts Here");
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
		executorService.submit(new LoopTaskC());
		executorService.submit(new LoopTaskC());
		executorService.submit(new LoopTaskC());
		
		
		System.out.println(" <"+ currentThread + " >"+ "Main Thread ENDS Here");
	}
}
