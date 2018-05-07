package ExecutorFramework1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingSingleThreadPoolExecutors {

	public static void main(String[] args) {
		System.out.println("MAIN THREAD START");
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		
		
		System.out.println("MAIN THREAD ENDS");
		
		executorService.shutdown();// avoid this cause memory leak
	}

}
