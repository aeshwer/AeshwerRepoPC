package com.udemyConcurreny;

public class SynBlockApp {

	private static int counter2 = 0;
	private static int counter1 = 0;

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void add1() {
		synchronized (lock1) {
			++counter1;
		}
	}

	public static void add2() {
		synchronized (lock2) {
			++counter2;
		}
	}

	/*
	 * INTRINSIC CLASS LEVEL LOCK public static synchronized void add1() //
	 * synchronized method { ++counter1; }
	 * 
	 * public static synchronized void add2() // synchronized method { ++counter2; }
	 */
	public static void process() {
		for (int i = 0; i < 100; ++i) {
			add1();
			add2();
		}

	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
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

		System.out.println("counter1 " + counter1 + " counter2 " + counter2);
	}

}
