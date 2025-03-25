package BussySpiningSolutionUsingConcurenyDS;

import java.util.concurrent.BlockingQueue;

public class ProducerThread implements Runnable {

	private final BlockingQueue<Integer> queue;

	ProducerThread(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " produced: " + i);
				queue.put(i); // Blocks if queue is full
				Thread.sleep(2000); // Simulate work
			}
			queue.put(-1); // Shutdown signal
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println(Thread.currentThread().getName() + " interrupted!");
		}
	}

}
