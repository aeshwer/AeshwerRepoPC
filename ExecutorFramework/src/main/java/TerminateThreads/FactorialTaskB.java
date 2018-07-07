package TerminateThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskB implements Callable<Long>{

	private static int count= 0; 
	private int instanceNumber;
	private String taskId;
	
	private long a;
	private long sleepTime;
	private long factorial;
	
	
	FactorialTaskB(long a,long sleepTime)
	{	this.sleepTime=sleepTime;
		this.a=a;
		this.instanceNumber = ++count;
		this.taskId= "FactorialTaskB-" + instanceNumber; 
	}
	
	public Long call(){
		String currentThread = Thread.currentThread().getName(); 
		
		System.out.println("####### [ "+ currentThread + "] <"+ taskId+ "> Starting #####");
		
		factorial=1L;
		for(long i=1;i<a;i++)
		{	
			factorial*=i;
			System.out.println("<"+  currentThread  +"] < "+ taskId+ "> Iteration- "+ i+ " Intermediate Resutlt = "+factorial);
		
			try {
				TimeUnit.MILLISECONDS.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> Sleep Interrupted Cancelling.......");
				factorial=-1L;
				break;
			}
		}
		System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> DONE #####");
		return factorial;
	}
	
}
