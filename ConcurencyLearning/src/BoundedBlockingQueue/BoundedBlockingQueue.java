package BoundedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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

public class BoundedBlockingQueue {

	private Queue<Integer> queue = new LinkedList<>();
	private int capacity;

	private final ReentrantLock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	public BoundedBlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	public void enqueue(int element) throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == capacity) {
				notFull.await(); // wait until space becomes available
			}
			queue.add(element);
			System.out.println("Produced: " + element);
			notEmpty.signal(); // wake up one waiting consumer
		} finally {
			lock.unlock();
		}
	}

	public int dequeue() throws InterruptedException {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				notEmpty.await(); // wait until an element is available
			}
			int item = queue.poll();
			System.out.println("Consumed: " + item);
			notFull.signal(); // wake up one waiting producer
			return item;
		} finally {
			lock.unlock();
		}
	}

	public int size() {
		lock.lock();
		try {
			return queue.size();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		BoundedBlockingQueue que = new BoundedBlockingQueue(3);
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
