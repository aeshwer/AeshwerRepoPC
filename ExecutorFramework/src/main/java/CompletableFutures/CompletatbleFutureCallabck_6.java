package CompletableFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletatbleFutureCallabck_6 {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<Integer> cf = new CompletableFuture<Integer>();

		cf.runAsync(() -> {
			System.out.println("First");
		}).thenRunAsync(() -> {
			System.out.println("Second");
		}).get(1000	, TimeUnit.MILLISECONDS);
		
		
	}

}
