/* In the following example we use the handle method to provide a default value when the asynchronous computation of a greeting was finished with an error because no name was provided:*/

package CompletableFutures;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HandlingErrors_4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		String name = null;

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			if (name == null) {
				throw new RuntimeException("Computation error!");
			}
			return "Hello, " + name;
		}).handle((s, throwable) -> s != null ? s : "Hello, Stranger!");

		assertEquals("Hello, Stranger!", completableFuture.get());

	}
}
