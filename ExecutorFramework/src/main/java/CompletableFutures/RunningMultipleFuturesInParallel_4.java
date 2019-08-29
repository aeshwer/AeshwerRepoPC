/*When we need to execute multiple Futures in parallel, we usually want to wait for all of them to execute and then process their combined results.
The CompletableFuture.allOf static method allows to wait for completion of all of the Futures provided as a var-arg:*/
package CompletableFutures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunningMultipleFuturesInParallel_4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

		combinedFuture.get();

		assertTrue(future1.isDone());
		assertTrue(future2.isDone());
		assertTrue(future3.isDone());

		String combined = Stream.of(future1, future2, future3).map(CompletableFuture::join)
				.collect(Collectors.joining(" "));

		assertEquals("Hello Beautiful World", combined);

	}

}
