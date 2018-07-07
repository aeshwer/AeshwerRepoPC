package TerminateThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import ExecutorFramework1.LoopTaskA;
import namingTheThread.NamedThreadFactory;

// Terminate at non blocking Point

public class ExecutorWayTerminateBlockedTask {

	public static void main(String[] args) throws InterruptedException {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
		
		LoopTaskA t1 = new LoopTaskA(); //Normal runnable task which blocks in between
		LoopTaskG t2 = new LoopTaskG(); //Normal runnable task which blocks in between but handles interupt correctly 
		FactorialTaskB t3 = new FactorialTaskB(30, 500); //Normal callable task which blocks in between but handles interupt correctly
		
		Future<?>  f1= executorService.submit(t1);
		Future<?>  f2= executorService.submit(t2);
		Future<?>  f3= executorService.submit(t3);
		
		executorService.shutdown();
		
		TimeUnit.MILLISECONDS.sleep(2000);

		System.out.println(currentThread + "Interuption Cancel on all tasks....");
		
		f1.cancel(true); // observe this  LoopTaskA gives exception but continuos to run ?? why?? It just exit and goes for next iteration...solution is to use a break at cathc block 
		f2.cancel(true);// observe this
		f3.cancel(true);// observe this
		
		System.out.println(currentThread + "Main Thread ENDS Here");
		}
}

