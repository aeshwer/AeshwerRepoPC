package com.udemyCollectionConcurrency;

import java.util.concurrent.CountDownLatch;

class Waiter implements Runnable {

	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			// Waits until countDown latch values is zero
			latch.await();
			System.out.println("Count fully decremented " + latch);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released");
	}
}

class Decrementer implements Runnable {

	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Realeased " + latch);
			this.latch.countDown();

			Thread.sleep(1000);
			System.out.println("Realeased " + latch);
			this.latch.countDown();

			Thread.sleep(1000);
			System.out.println("Realeased " + latch);
			this.latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class CountDownLatchLearn {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);
		new Thread(waiter).start();
		new Thread(decrementer).start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
