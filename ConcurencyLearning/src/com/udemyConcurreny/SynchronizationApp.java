package com.udemyConcurreny;

public class SynchronizationApp {

	private static int counter = 0;

	public static synchronized void increment() // synchronized method
	{
		++counter;
	}

	public static void process() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					// ++counter;
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					// ++counter;
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		process();
		System.out.println(counter);
	}
}
