package ReturningValues;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ExecutorFramework1.LoopTaskA;
import namingTheThread.NamedThreadFactory;

public class ReturningValueExecutorsSecondWay {
	
	public static void main(String[] args) {
		
String currentThread = Thread.currentThread().getName(); 
		
		System.out.println(currentThread + "Main Thread Starts Here");
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
		
		CompletionService<TaskResult<String, Integer>> completionService = new ExecutorCompletionService<TaskResult<String,Integer>>(executorService);
		

		completionService.submit(new CalculationTaskB(1, 0, 2000));
		completionService.submit(new CalculationTaskB(1, 1, 1000));
		completionService.submit(new CalculationTaskB(1, 2, 500));
		
		// can also submit runnable task to submit method. These task do not return value ...so how to know when they are ended 
		//Solution: capture the future instance element using a unknown wild-card 
		//Future<?> result4 = executorService.submit(new LoopTaskA());  syntax invalid
		completionService.submit(new LoopTaskA(),new TaskResult<String, Integer>("LoopTaskA-1", 999));
		
		executorService.shutdown();
		
		// completion service takes care of tasks and gives result as task are done irrespective of the order they are completed
		for(int i=0;i<4;i++ ) 
		{
			try {
				System.out.println(completionService.take().get());
				//take() returns the future of the next completed task and the get() method on that future returns the result of task execution.
				// if there is no completed task when take is invoked then it blocks till next task is completed
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}
