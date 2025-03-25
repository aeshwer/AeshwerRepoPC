package BussySpiningSolutionUsingConcurenyDS;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BustSpinSolutionUsingDSDemo {

	// BASIC
	/*
	 * public static void main(String[] args) { BlockingQueue<Integer> queue = new
	 * LinkedBlockingQueue<>();
	 * 
	 * int numProducers = 3; // Number of producer threads int numConsumers = 3; //
	 * Number of consumer threads
	 * 
	 * // Start producers for (int i = 0; i < numProducers; i++) { new Thread(new
	 * ProducerThread(queue), "Producer-" + i).start(); }
	 * 
	 * // Start consumers for (int i = 0; i < numConsumers; i++) { new Thread(new
	 * ConsumerThread(queue), "Consumer-" + i).start(); } }
	 */

	// Updated Code with Auto-Scaling Consumers
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

		int numProducers = 3; // Number of producer threads
		int coreConsumers = 2; // Minimum number of consumer threads
		int maxConsumers = 5; // Maximum number of consumer threads
		int keepAliveTime = 10; // Seconds before removing idle threads

		// Create a thread pool that auto-scales consumers
		ThreadPoolExecutor consumerPool = new ThreadPoolExecutor(coreConsumers, maxConsumers, keepAliveTime,
				TimeUnit.SECONDS, new SynchronousQueue<>(), // Allows immediate scaling
				new ThreadPoolExecutor.CallerRunsPolicy() // Prevents dropping tasks
		);

		// Start producers
		for (int i = 0; i < numProducers; i++) {
			new Thread(new ProducerThread(queue), "Producer-" + i).start();
		}

		// Start initial consumers
		for (int i = 0; i < coreConsumers; i++) {
			consumerPool.execute(new ConsumerThread(queue));
		}

		// Monitor queue and adjust consumers dynamically
		new Thread(() -> {
			while (true) {
				int queueSize = queue.size();
				int activeConsumers = consumerPool.getActiveCount();

				if (queueSize > activeConsumers) {
					System.out.println("🔹 Scaling up consumers. Queue size: " + queueSize);
					consumerPool.execute(new ConsumerThread(queue));
				}

				try {
					Thread.sleep(2000); // Monitor every 2 seconds
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}
		}).start();
	}
}