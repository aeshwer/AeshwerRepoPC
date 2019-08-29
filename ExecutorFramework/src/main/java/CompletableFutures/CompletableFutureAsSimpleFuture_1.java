// In the example below we have a method that creates a CompletableFuture instance, then spins off some computation in
// another thread and returns the Future immediately.
package CompletableFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureAsSimpleFuture_1 {
	
	public Future<String> calculateAsync() throws InterruptedException {
	    final CompletableFuture<String> completableFuture 
	      = new CompletableFuture<String>();
	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(500);
	        completableFuture.complete("Hello");
	        return null;
	    });
	 
	    return completableFuture;
	}

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFutureAsSimpleFuture_1 obj = new CompletableFutureAsSimpleFuture_1();
		
		Future<String> calculateAsync = obj.calculateAsync();
		System.out.println(calculateAsync.get());
	}
}
