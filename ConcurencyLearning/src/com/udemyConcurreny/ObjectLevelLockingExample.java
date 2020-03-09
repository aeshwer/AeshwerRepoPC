/*Object level locking is mechanism when you want to synchronize a non-static method 
 * or non-static code block such that only one thread will be able to execute the code
 *  block on given instance of the class.
 *  This should always be done to make instance level data thread safe.
 * 
 */
package com.udemyConcurreny;

import java.util.concurrent.TimeUnit;

// Java program to illustrate Object lock concept
public class ObjectLevelLockingExample implements Runnable{
	    public void run()
	    {
	        try {
				Lock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    public void Lock() throws InterruptedException
	    {
	        System.out.println(Thread.currentThread().getName());
	        synchronized(this)
	        {
	            System.out.println("in block "
	                + Thread.currentThread().getName());
	            TimeUnit.MILLISECONDS.sleep(2000);
	            System.out.println("in block " + 
	                Thread.currentThread().getName() + " end");
	        }
	    }
	 
	    public static void main(String[] args)
	    {
	    	ObjectLevelLockingExample g = new ObjectLevelLockingExample();
	        Thread t1 = new Thread(g);
	        Thread t2 = new Thread(g);
	        ObjectLevelLockingExample g1 = new ObjectLevelLockingExample();
	        Thread t3 = new Thread(g1);
	        t1.setName("t1");
	        t2.setName("t2");
	        t3.setName("t3");
	        t1.start();
	        t2.start();
	        t3.start();
	    }
}
