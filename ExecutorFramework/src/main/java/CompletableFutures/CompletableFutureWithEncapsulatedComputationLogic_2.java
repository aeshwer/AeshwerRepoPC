//https://www.baeldung.com/java-completablefuture
//Static methods runAsync and supplyAsync allow us to create a CompletableFuture instance out of Runnable and Supplier functional types correspondingly.
package CompletableFutures;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureWithEncapsulatedComputationLogic_2 {

	public static void main(String[] args) {
		CompletableFutureWithEncapsulatedComputationLogic_2 obj = new CompletableFutureWithEncapsulatedComputationLogic_2();

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

		/*
		 * The most generic way to process the result of a computation is to feed it to
		 * a function. The thenApply method does exactly that: accepts a Function
		 * instance, uses it to process the result and returns a Future that holds a
		 * value returned by a function:
		 */
		CompletableFuture<String> future1 = completableFuture.thenApply(s -> s + " World");

		/*
		 * If you don't need to return a value down the Future chain, you can use an
		 * instance of the Consumer functional interface. Its single method takes a
		 * parameter and returns void.
		 */

		CompletableFuture<Void> future2 = completableFuture
				.thenAccept(s -> System.out.println("Computation returned: " + s));

		/*
		 * At last, if you neither need the value of the computation nor want to return
		 * some value at the end of the chain, then you can pass a Runnable lambda to
		 * the thenRun method. In the following example, after the future.get() method
		 * is called, we simply print a line in the console:
		 */
		
		CompletableFuture<Void> future3 = completableFuture
				  .thenRun(() -> System.out.println("Computation finished."));

	}

}
