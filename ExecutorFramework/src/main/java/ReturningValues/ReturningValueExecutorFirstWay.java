package ReturningValues;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


import ExecutorFramework1.LoopTaskA;
import namingTheThread.NamedThreadFactory;

public class ReturningValueExecutorFirstWay {
	
	public static void main(String[] args) {
String currentThread = Thread.currentThread().getName(); 
		
		System.out.println(currentThread + "Main Thread Starts Here");
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

		Future<Integer>  result1 = executorService.submit(new CalculationTaskA(2, 3, 2000));
		Future<Integer>  result2 = executorService.submit(new CalculationTaskA(2, 3, 1000));
		Future<Integer>  result3 = executorService.submit(new CalculationTaskA(2, 3, 500));
		
		// can also submit runnable task to submit method. These task do not return value ...so how to know when they are ended 
		//Solution: capture the future instance element using a unknown wild-card 
		Future<?> result4 = executorService.submit(new LoopTaskA());
		Future<Double> result5 = executorService.submit(new LoopTaskA(),999.999);
		
		executorService.shutdown();
		
		// since it is a blocking call here ,.... so we get result in order we wrote the lines...rather than the way the thread arrived
		try {
		System.out.println("Result-1 =" + result1.get()); // blocking call get() method
	    System.out.println("Result-2 =" + result2.get());
	    System.out.println("Result-3 =" + result3.get());
	    System.out.println("Result-4 =" + result4.get());
		System.out.println("Result-5 =" + result5.get());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}
