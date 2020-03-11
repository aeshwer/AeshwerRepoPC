package com.udemyConcurreny;

//Observe here all static syn methods are blocked
import java.util.concurrent.TimeUnit;

public class MoreGrillingOnStaticSync implements Runnable {

	@Override
	public void run() {

		if (Integer.parseInt(Thread.currentThread().getName()) == 1) {
			method1();
		} else {
			method2();
		}
	}

	private static synchronized void method1() {
		System.out.println("In Method 1");
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished waiting in Method 1");
	}

	private static synchronized void method2() {
		System.out.println("In Method ");
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished waiting in Method 2");
	}

	public static void main(String[] args) {
		MoreGrillingOnStaticSync obj1 = new MoreGrillingOnStaticSync();
		Thread t1 = new Thread(obj1, "1");
		Thread t2 = new Thread(obj1, "2");

		t1.start();
		t2.start();

	}

}
