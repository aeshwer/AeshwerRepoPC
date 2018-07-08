package CheckingIfThreadIsAlive;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import ReturningValues.CalculationTaskA;
import namingTheThread.LoopTaskC;
import namingTheThread.NamedThreadFactory;

// executor thread go in wait state after completion of task....
public class ExecutorWayCheck {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");

		ExecutorService executorService =  Executors.newCachedThreadPool(new NamedThreadFactory());
		Future<?> f1 = executorService.submit(new LoopTaskC());
		Future<Integer> f2 = executorService.submit(new CalculationTaskA(3, 4, 700));
		
		FutureTask<?> f3 = new FutureTask<Void>(new LoopTaskC(),null);   // concrete implementation of Future 
		// here me made the runnable loopTaskC return a null value
		
		FutureTask<?> f4 = new FutureTask<Integer>(new LoopTaskC(),999);   // concrete implementation of Future
		FutureTask<Integer> f5 = new FutureTask<Integer>(new CalculationTaskA(3, 4, 500));   // concrete implementation of Future
		// here me made use of callable interface

		executorService.execute(f3);
		executorService.execute(f4);
		executorService.execute(f5);
		
		executorService.shutdown();

		for(int i =1 ;i<=5 ; i++ ) 
		{
			try {
				TimeUnit.MILLISECONDS.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("#######  ["+ currentThread + "] ITR- "+ "i" + "'LooptaskC-1' done = "+f1.isDone());
			System.out.println("#######  ["+ currentThread + "] ITR- "+ "i" + "'CalcTaskA-1' done = "+f2.isDone());
			System.out.println("#######  ["+ currentThread + "] ITR- "+ "i" + "'LooptaskC-2' done = "+f3.isDone());
			System.out.println("#######  ["+ currentThread + "] ITR- "+ "i" + "'CalcTaskA-2' done = "+f4.isDone());
			System.out.println("#######  ["+ currentThread + "] ITR- "+ "i" + "'CalcTaskA-2' done = "+f5.isDone());
		}

		System.out.println("\n$$$$$["+ currentThread +"] Retriving Result now $$$$$");
		
		System.out.println("["+ currentThread + "] 'LooptaskC-1' done Result  = "+f1.get());
		System.out.println("["+ currentThread + "] 'CalcTaskA-1' done Result  = "+f2.get());
		System.out.println("["+ currentThread + "] 'LooptaskC-2' done Result  = "+f3.get());
		System.out.println("["+ currentThread + "] 'CalcTaskA-2' done Result  = "+f4.get());
		System.out.println("["+ currentThread + "] 'CalcTaskA-2' done  Result = "+f5.get());
		
		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}
