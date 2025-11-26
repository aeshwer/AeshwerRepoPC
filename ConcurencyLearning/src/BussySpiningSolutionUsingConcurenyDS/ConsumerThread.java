package BussySpiningSolutionUsingConcurenyDS;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConsumerThread implements Runnable {

	private final BlockingQueue<Integer> queue;

	ConsumerThread(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Integer data = queue.poll(1000, TimeUnit.MILLISECONDS); // Waits if queue is empty

                if (data == null) {
                    System.out.println(Thread.currentThread().getName() + " timed out. Retrying...");
                    continue;
                }
                
				if (data == -1) { // Shutdown signal
					System.out.println(Thread.currentThread().getName() + " received shutdown signal. Exiting...");
					//queue.put(-1); // Pass shutdown signal to other consumers
					break;
				}
				System.out.println(Thread.currentThread().getName() + " consumed: " + data);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println(Thread.currentThread().getName() + " interrupted!");
		}
	}
}
