package connectionPoolRetry;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConnectionPoolRetryMain {

	public static void main(String[] args) throws Exception {
		ConnectionPoolService pool = ConnectionPoolService.getInstance();
		ExecutorService executor = Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 5; i++) {
			final int threadId = i;
			executor.submit(() -> {
				try {
					System.out.println("Thread " + threadId + ": Requesting connection...");
					Connection conn = pool.getConnection();
					System.out.println("Thread " + threadId + ": SUCCESS! Got connection: " + conn);
					Thread.sleep(2000);
					System.out.println("Thread " + threadId + ": Releasing connection...");
					conn.close();
				} catch (Exception e) {
					System.err.println("Thread " + threadId + " failed: " + e.getMessage());
				}

			});
		}

		executor.shutdown();
		executor.awaitTermination(15, TimeUnit.SECONDS);

		System.out.println("\nSimulation complete. Closing the pool...");
		pool.shutdown();
	}
}
