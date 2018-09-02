/*Class level locking prevents multiple threads to enter in synchronized block in any of
 *  all available instances on runtime. This means if in runtime there are 100 instances of 
 *   DemoClass, then only one thread will be able to execute demoMethod() in any one of instance
 *    at a time, and all other instances will be locked for other threads.
 *  This should always be done to make static data thread safe.
 * 
 */
package com.udemyConcurreny;

// Java program to illustrate Object lock concept
public class ReentrantNatureOfSynchronizedBlock implements Runnable{
	    public void run()
	    {
	        Lock1();
	    }
	    public void Lock1()
	    {
	        System.out.println(Thread.currentThread().getName());
	        synchronized(this)
	        {
	            System.out.println("in block lock1 "
	                + Thread.currentThread().getName());
	            System.out.println("in block lock 1 " + 
	                Thread.currentThread().getName() + " end");
	            Lock2();
	        }
	    }
	    
		private  void Lock2()
	    {
	        synchronized(this)
	        {
	            System.out.println("in block lock 2 "
	                + Thread.currentThread().getName());
	            System.out.println("in block lock 2 " + 
	                Thread.currentThread().getName() + " end");
	        }
	    }
	 
	    public static void main(String[] args)
	    {
	    	ReentrantNatureOfSynchronizedBlock g = new ReentrantNatureOfSynchronizedBlock();
	        Thread t1 = new Thread(g);
	        Thread t2 = new Thread(g);
	        ReentrantNatureOfSynchronizedBlock g1 = new ReentrantNatureOfSynchronizedBlock();
	        Thread t3 = new Thread(g1);
	        t1.setName("t1");
	        t2.setName("t2");
	        t3.setName("t3");
	        t1.start();
	        t2.start();
	        t3.start();
	    }
}
