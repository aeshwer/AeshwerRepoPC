package TerminateThreads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import ExecutorFramework1.LoopTaskA;
import ReturningValues.CalculationTaskB;
import ReturningValues.TaskResult;
import namingTheThread.NamedThreadFactory;

// Terminate at non blocking Point

public class ExecutorWayTerminateAllTask {

	public static void main(String[] args) throws Exception {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");

		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

		LoopTaskA t1 = new LoopTaskA(); //Normal runnable task which blocks in between
		LoopTaskF t2 = new LoopTaskF(); //Normal runnable task which DONT blocks in between...observe sleep method
		FactorialTaskB t3 = new FactorialTaskB(30, 500); //Normal callable task which blocks in between but handles interupt correctly
		CalculationTaskC t4 = new CalculationTaskC(); //Normal callable task which DONT blocks
		CalculationTaskB t5 = new CalculationTaskB(2, 3, 9000);//Normal callable task which blocks and DONT handle interupt

		Future<?>  f1= executorService.submit(t1);
		Future<?>  f2= executorService.submit(t2);
		Future<Long>  f3= executorService.submit(t3);
		Future<Long>  f4= executorService.submit(t4);
		Future<TaskResult<String,Integer>>  f5= executorService.submit(t5);

		//executorService.shutdown(); //dont attempt to terminate the task
		executorService.shutdownNow(); //Attempt to terminate the task

		TimeUnit.MILLISECONDS.sleep(2000);

		System.out.println("["+ currentThread + "] All Threads Temrinated...."+ executorService.awaitTermination(5000, TimeUnit.MILLISECONDS));
		// if wait time above is less..args then we get false

		System.out.println("["+ currentThread + "] Factorial TaskB-1 Result= "+ f3.get());
		System.out.println("["+ currentThread + "] CalcTaskC-1 Result= "+ f4.get());

		try {
			System.out.println("["+ currentThread + "] CalcTAsbB-1TaskB-1 Result= "+ f5.get()); // get method here gives a execution exception if try catch not used
		}
		catch(ExecutionException e) 
		{
			System.out.println("["+ currentThread + "] CalcTAsbB-1TaskB-1 Got Exception .The cause is : \n");
			e.getCause().printStackTrace();
		}

		System.out.println(currentThread + "Main Thread ENDS Here");
	}
}

