package DaemonThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorWayForDaemonThread {

	public static void main(String[] args) {
		String currentThread = Thread.currentThread().getName(); 
		
		System.out.println(currentThread + "Main Thread Starts Here");
		
		ExecutorService executorService= Executors.newCachedThreadPool(new DaemonThreadFactory());
		executorService.execute(new LoopTaskD(100));
		executorService.execute(new LoopTaskD(200));//Daemon as per DeamonThradFactory login
		executorService.execute(new LoopTaskD(100));
		executorService.execute(new LoopTaskD(200));//Daemon as per DeamonThradFactory login

		executorService.shutdown();
		
		System.out.println(currentThread + "Main Thread ENDS Here");
		}

}
