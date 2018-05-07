package ExecutorFramework1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPoolExecutors {

	public static void main(String[] args) {
System.out.println("MAIN THREAD START");
		
		ExecutorService executorService = Executors.newCachedThreadPool(); // number of threads are not fixed..here extra task do not have to wait for thread as there is no limit on number of threads
		
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		

		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		
		System.out.println("MAIN THREAD ENDS");
		
		executorService.shutdown();// avoid this cause memory leak
	}

}
