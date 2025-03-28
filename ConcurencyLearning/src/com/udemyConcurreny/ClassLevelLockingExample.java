/*Class level locking prevents multiple threads to enter in synchronized block in any of
 *  all available instances on runtime. This means if in runtime there are 100 instances of 
 *   DemoClass, then only one thread will be able to execute demoMethod() in any one of instance
 *    at a time, and all other instances will be locked for other threads.
 *  This should always be done to make static data thread safe.
 * 
 */
package com.udemyConcurreny;

import java.util.concurrent.TimeUnit;

// Java program to illustrate Object lock concept
public class ClassLevelLockingExample implements Runnable {
	public void run() {
		try {
			Lock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void Lock() throws InterruptedException {
		synchronized (ClassLevelLockingExample.class) {
			System.out.println("in block " + Thread.currentThread().getName());
			TimeUnit.MILLISECONDS.sleep(2000);
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		ClassLevelLockingExample g = new ClassLevelLockingExample();
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(g);
		ClassLevelLockingExample g1 = new ClassLevelLockingExample();
		Thread t3 = new Thread(g1);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
