package BoundedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Implement a bounded blocking queue with:
A capacity (max number of items)

These methods (all must be thread-safe):
1. void enqueue(int element)
Adds element to queue
Blocks if queue is full
Resumes when space becomes available

2. int dequeue()
Removes element from queue
Blocks if queue is empty
Resumes when an element is available

3. int size()
Returns current queue size
 * */

public class BoundedBlockingQueue2 {

	private Semaphore putLock;
	private Semaphore getLock;
	private final Object lock = new Object();
	Queue<Integer> que;

	public BoundedBlockingQueue2(int capacity) {
		this.putLock = new Semaphore(capacity);
		this.getLock = new Semaphore(0);
		this.que = new LinkedList<Integer>();
	}

	public void enqueue(int element) throws InterruptedException {
		putLock.acquire(); // wait for space

		synchronized (lock) {
			System.out.println("Produced: " + element);
			que.add(element);
		}

		getLock.release(); // signal that item is available
	}

	public int dequeue() throws InterruptedException {
		getLock.acquire(); // wait for item

		int result;
		synchronized (lock) {
			result = que.poll();
			System.out.println("Consumed: " + result);
		}

		putLock.release(); // signal that space is available
		return result;
	}

	public int size() {
		synchronized (lock) {
			return que.size();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		BoundedBlockingQueue2 que = new BoundedBlockingQueue2(3);
		ExecutorService executor = Executors.newCachedThreadPool();
		AtomicInteger count = new AtomicInteger(1);

		// Producer
		for (int i = 0; i < 5; i++) {
			executor.submit(() -> {
				try {
					que.enqueue(count.incrementAndGet());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

		// Thread.sleep(1000);

		// Consumer
		for (int i = 0; i < 2; i++) {
			executor.submit(() -> {
				try {
					que.dequeue();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});

		}

	}
}
