package PuzzelProblem;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class App {

	private volatile static int counterSeconds = 0;

	void callAfterDealy(Runnable r, int seconds) {
		while (seconds != counterSeconds) {
			// Run until the delay
		}
		r.run();

	}

	void tick() {
		System.out.println("Tick Called - " + counterSeconds + " seconds");
		counterSeconds++;
	}

	public static void main(String[] args) throws InterruptedException {
		App tester = new App();
		A1 obj1 = new A1(3);
		A2 obj2 = new A2(2);
		A2 obj3 = new A2(5);
		A2 obj4 = new A2(1);

		CompletableFuture.runAsync(() -> tester.callAfterDealy(obj1, 3));
		CompletableFuture.runAsync(() -> tester.callAfterDealy(obj2, 2));
		CompletableFuture.runAsync(() -> tester.callAfterDealy(obj3, 5));
		CompletableFuture.runAsync(() -> tester.callAfterDealy(obj4, 1));
		
		/*CompletableFuture.runAsync(obj1, CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS));
		CompletableFuture.runAsync(obj2, CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS));
		CompletableFuture.runAsync(obj3, CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS));
		CompletableFuture.runAsync(obj4, CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));*/

		while (true) {
			Thread.sleep(1000);
			tester.tick();
		}

	}

}
