package com.udemyCollectionConcurrency;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class DelayQueueExample {
	public static class DelayQueueProducer implements Runnable {

		private BlockingQueue<DelayedElement> queue;
		private Integer numberOfElementsToProduce;
		private Long delayOfEachProducedMessageMilliseconds;

		// standard constructor
		public DelayQueueProducer(BlockingQueue<DelayedElement> queue, int numberOfElementsToProduce,
				long delayOfEachProducedMessageMilliseconds) {
			this.queue = queue;
			this.numberOfElementsToProduce = numberOfElementsToProduce;
			this.delayOfEachProducedMessageMilliseconds = delayOfEachProducedMessageMilliseconds;
		}

		@Override
		public void run() {
			for (int i = 0; i < numberOfElementsToProduce; i++) {
				DelayedElement object = new DelayedElement(UUID.randomUUID().toString(),System.currentTimeMillis()+
						delayOfEachProducedMessageMilliseconds);
				System.out.println("Put object: " + object);
				try {
					queue.put(object);
					Thread.sleep(500);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}

	public static class DelayQueueConsumer implements Runnable {
		private BlockingQueue<DelayedElement> queue;
		private Integer numberOfElementsToTake;
		public AtomicInteger numberOfConsumedElements = new AtomicInteger();

		public DelayQueueConsumer(BlockingQueue<DelayedElement> queue, Integer numberOfElementsToTake) {
			this.queue = queue;
			this.numberOfElementsToTake = numberOfElementsToTake;
		}

		// standard constructors

		@Override
		public void run() {
			for (int i = 0; i < numberOfElementsToTake; i++) {
				try {
					DelayedElement object = queue.take();
					numberOfConsumedElements.incrementAndGet();
					System.out.println("Consumer take: " + object);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// given
		ExecutorService executor = Executors.newFixedThreadPool(2);

		BlockingQueue<DelayedElement> queue = new DelayQueue<>();
		int numberOfElementsToProduce = 2;
		long delayOfEachProducedMessageMilliseconds = 5000;
		DelayQueueConsumer consumer = new DelayQueueConsumer(queue, 2);
		DelayQueueProducer producer = new DelayQueueProducer(queue, numberOfElementsToProduce,
				delayOfEachProducedMessageMilliseconds);

		// when
		executor.submit(producer);
		executor.submit(consumer);

		// then
		executor.shutdown();

		if (consumer.numberOfConsumedElements.get() == numberOfElementsToProduce) {
			System.out.println("Happy Case");
		}

	}

}
