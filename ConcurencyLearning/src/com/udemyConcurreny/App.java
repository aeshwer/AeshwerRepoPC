package com.udemyConcurreny;

class runner1 implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Runner1");
		}
	}
}

class runner2 implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Runner2");
		}
	}
}

public class App {
	public static void main(String[] args) {

		Thread t1 = new Thread(new runner1());
		Thread t2 = new Thread(new runner2());

		// start: method begins the execution of a new thread
		t1.start();
		t2.start();
		// Join:allows one thread to wait for another thread to finish execution before
		// continuing.
		try {
			// Main thread waits until t1 is done
			t1.join();
			// Main thread waits until t2 is done
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Finished");
	}

}
