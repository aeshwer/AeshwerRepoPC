// The best part of the CompletableFuture API is the ability to combine CompletableFuture instances in a chain of computation steps.
// In the following example we use the thenCompose method to chain two Futures sequentially.
package CompletableFutures;

import java.util.concurrent.CompletableFuture;

public class CombingFutures_3 {

	public static void main(String[] args) {

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
				.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

		// thenApply():- So this method is useful when we want to transform the result of a CompletableFuture call:
		// thenCompose():- So if the idea is to chain CompletableFuture methods then it’s better to use thenCompose().
	}

}
