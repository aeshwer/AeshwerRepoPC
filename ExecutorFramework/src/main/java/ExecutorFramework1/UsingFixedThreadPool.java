package ExecutorFramework1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {

	public static void main(String[] args) {
		System.out.println("MAIN THREAD START");
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		// Only 3 threads run at one time
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		
		System.out.println("MAIN THREAD ENDS");
		
		executorService.shutdown();// avoid this cause memory leak
	}
}
