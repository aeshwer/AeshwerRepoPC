package connectionPool;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class connectPoolMain {

	public static void main(String[] args) throws Exception {
		System.out.println("--- Starting Connection Pool Simulation ---");

		// 1. Get our Singleton Pool (Assumes 2 min, 5 max)
		final CustomConnectionPool pool = MyConnectionPool.getInstance();

		// 2. Create an Executor to simulate concurrent users
		ExecutorService executor = Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 5; i++) {
			final int threadId = i;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("Thread " + threadId + ": Requesting connection...");

						// This will BLOCK if the pool is empty
						Connection conn = pool.getConnection();

						System.out.println("Thread " + threadId + ": SUCCESS! Got connection: " + conn);

						// Simulate doing work (2 seconds)
						Thread.sleep(2000);

						System.out.println("Thread " + threadId + ": Releasing connection...");
						conn.close(); // Remember: Our Proxy redirects this to pool.release()

					} catch (Exception e) {
						System.err.println("Thread " + threadId + " failed: " + e.getMessage());
					}
				}
			});
		}

		// 3. Graceful shutdown of the simulation
		executor.shutdown();
		executor.awaitTermination(15, TimeUnit.SECONDS);

		System.out.println("\nSimulation complete. Closing the pool...");
		pool.shutdown();
	}
}