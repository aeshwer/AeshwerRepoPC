package TerminateThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskA implements Callable<Long>{

	private static int count= 0; 
	private int instanceNumber;
	private String taskId;
	private volatile boolean shutdown = false;
	
	private long a;
	private long sleepTime;
	private long factorial;
	
	
	FactorialTaskA(long a,long sleepTime)
	{	this.sleepTime=sleepTime;
		this.a=a;
		this.instanceNumber = ++count;
		this.taskId= "FactorialTaskA" + instanceNumber; 
	}
	
	public Long call() throws Exception{
		String currentThread = Thread.currentThread().getName(); 
		
		System.out.println("####### [ "+ currentThread + "] <"+ taskId+ "> Starting #####");
		
		factorial=1L;
		for(long i=1;i<a;i++)
		{	
			factorial*=i;
			System.out.println("<"+  currentThread  +"] < "+ taskId+ "> Iteration- "+ i+ " Intermediate Resutlt = "+factorial);
		
			TimeUnit.MILLISECONDS.sleep(sleepTime);
			synchronized (this) {
			if(shutdown) {
				factorial=-1L; // reset value
				break;
				}
			}
		}
		System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> DONE #####");
		return factorial;
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
