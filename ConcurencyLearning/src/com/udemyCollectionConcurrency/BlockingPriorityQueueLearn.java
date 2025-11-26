package com.udemyCollectionConcurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstWorker1 implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public FirstWorker1(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			System.out.println("Putting Item to Queue ");
			blockingQueue.put("D");
			blockingQueue.put("Z");
			Thread.sleep(1000);
			blockingQueue.put("C");
			blockingQueue.put("A");
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class SecondWorker2 implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public SecondWorker2(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			System.out.println("waiting to consume Item from Queue ");
			Thread.sleep(5000); // ensure the put operation is complete so we get a sorted output
			System.out.println("Consuming now");
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

public class BlockingPriorityQueueLearn {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new PriorityBlockingQueue<String>();

		FirstWorker1 firstWorker = new FirstWorker1(queue);
		SecondWorker2 secondWorker = new SecondWorker2(queue);

		new Thread(firstWorker).start();
		new Thread(secondWorker).start();

	}
}
