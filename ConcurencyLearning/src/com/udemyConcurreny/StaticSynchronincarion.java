package com.udemyConcurreny;

public class StaticSynchronincarion implements Runnable{
	 public void run()
	    {
	        Lock2();
	    }
	    public static synchronized void Lock()
	    {
	            System.out.println("in block lock 1 :"
	                + Thread.currentThread().getName());
	            System.out.println("in block lock 1 :" + 
	                Thread.currentThread().getName() + " end");
	    }
	    
	    public synchronized void Lock2()
	    {
	            System.out.println("in block lock 2 :"
	                + Thread.currentThread().getName());
	            System.out.println("in block lock 2  :" + 
	                Thread.currentThread().getName() + " end");
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
