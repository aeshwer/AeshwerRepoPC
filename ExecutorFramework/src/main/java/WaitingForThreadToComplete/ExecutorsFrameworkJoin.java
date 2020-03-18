package WaitingForThreadToComplete;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import namingTheThread.NamedThreadFactory;

public class ExecutorsFrameworkJoin {public static void main(String[] args) throws InterruptedException{

	String currentThread = Thread.currentThread().getName(); 

	System.out.println(currentThread + "Main Thread Starts Here");

	ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
	CountDownLatch latch = new CountDownLatch(3);

	executorService.submit(new LoopTaskI(latch));
	executorService.submit(new LoopTaskI(latch));
	executorService.submit(new LoopTaskI(latch));

	executorService.shutdown();
	try{
		latch.await();
		System.out.println("####### [ "+   currentThread + "] Got the signal to continue.... "	);
	}
	catch(InterruptedException e) 
	{
		e.printStackTrace();
	}
	System.out.println(currentThread + "Main Thread ENDS Here");
	}
}
