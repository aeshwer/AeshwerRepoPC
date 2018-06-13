package TerminateThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import namingTheThread.NamedThreadFactory;

// Terminate at non blocking Point

public class ExecutorWayTerminateSecondWay {

	public static void main(String[] args) throws InterruptedException {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
		
		CalculationTaskC t1 = new CalculationTaskC();
		LoopTaskF t2 = new LoopTaskF();
		
		Future<Long> f1 =executorService.submit(t1);
		Future<?>  f2= executorService.submit(t2);
		
		executorService.shutdown();
		
		TimeUnit.MILLISECONDS.sleep(3000);

		System.out.println(currentThread + "INteruption CalculationTaskC ...");
		
		f1.cancel(true); // observe this
		
		System.out.println(currentThread + "INteruption LoopTaskF ...");
		f2.cancel(true);// observe this
		
		System.out.println(currentThread + "Main Thread ENDS Here");
		}
}

