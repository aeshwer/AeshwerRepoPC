package TerminateThreads;

import java.util.concurrent.TimeUnit;

public class LoopTaskE implements Runnable{

	private static int count= 0; 
	private int instanceNumber;
	private String taskId;
	private volatile boolean shutdown;
	
	LoopTaskE()
	{	this.instanceNumber = ++count;
		this.taskId= "LoopTaskE" + instanceNumber; 
	}
	
	public void run() {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println("####### [ "+ currentThread + "] <"+ taskId+ "> Starting #####");
		
		for(int i=10;i>0;i--) 
		{
			System.out.println("<"+  currentThread  +"] < "+ taskId+ ">"+ " TICK TICK "+i);
		
		try {
			TimeUnit.MILLISECONDS.sleep((long) (Math.random()*3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		synchronized (this) {
			if(shutdown) {break;}
			}
		}
		System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> DONE #####");
	}
	
	// need method to shut this task which will be called from some other class
	public void cancle() 
	{
		System.out.println("####### [ "+   Thread.currentThread().getName() + "] <"+ taskId+ "> SHUTING DOWN #####");
		synchronized (this) {
			this.shutdown = true;
		}
	}
}
