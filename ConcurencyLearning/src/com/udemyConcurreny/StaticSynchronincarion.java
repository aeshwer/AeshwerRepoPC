/*
 * Answer: Static synchronized methods synchronize on the class object. If one thread is executing a static synchronized method, 
 * all other threads trying to execute any static synchronized methods will be blocked. 
 * Non-static synchronized methods synchronize on this ie the instance of the class.
 */

package com.udemyConcurreny;

import java.util.concurrent.TimeUnit;

public class StaticSynchronincarion implements Runnable {
	public void run() {
		try {
			Lock2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void Lock() throws InterruptedException {
		System.out.println("in block lock 1 :" + Thread.currentThread().getName());
		TimeUnit.MILLISECONDS.sleep(2000);
		System.out.println("in block lock 1 :" + Thread.currentThread().getName() + " end");
	}

	public synchronized void Lock2() throws InterruptedException {
		System.out.println("in block lock 2 :" + Thread.currentThread().getName());
		TimeUnit.MILLISECONDS.sleep(2000);
		System.out.println("in block lock 2  :" + Thread.currentThread().getName() + " end");
		Lock();
	}

	public static void main(String[] args) {
		StaticSynchronincarion g = new StaticSynchronincarion();
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(g);
		StaticSynchronincarion g1 = new StaticSynchronincarion();
		Thread t3 = new Thread(g1);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
