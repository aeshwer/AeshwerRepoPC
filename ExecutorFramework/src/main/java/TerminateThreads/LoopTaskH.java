package TerminateThreads;

import java.util.concurrent.TimeUnit;

//Need a task that blocks .. all is same as loop taskG but here we want to catch interrupted at blocking part of code(sleep) and actually 
// terminate thread at some later point....simply use a flag variable for this 



public class LoopTaskH implements Runnable{

	private static int count= 0; 
	private int instanceNumber;
	private String taskId;
	private boolean sleepIterupt= false;
	
	LoopTaskH()
	{	this.instanceNumber = ++count;
		this.taskId= "LoopTaskH" + instanceNumber; 
	}
	
	public void run() {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println("####### [ "+ currentThread + "] <"+ taskId+ "> Starting #####");
		
		for(int i=1;;i++) 
		{
			System.out.println("<"+  currentThread  +"] < "+ taskId+ ">"+ " TICK TICK "+i);
			 
			try {
				TimeUnit.MILLISECONDS.sleep((long) (Math.random()*3000));
			} catch (InterruptedException e) {
				System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> SLEEP INTERRUPTED ........ Setting FLAG ");
				sleepIterupt = true;
			}
			
			doSomeWork(); // we do some work and after that we check the flag and terminate thread
			
			if(sleepIterupt || Thread.interrupted()) 
			{
				System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> INTERRUPTED ...cancelling...... ");
				break;
			}
		}
		
		System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> DONE #####");
		
	}

	private void doSomeWork() {
		System.out.println("####### [ "+ Thread.currentThread().getName() + "] <"+ taskId+ "> DO SOME WORK.............");		
	}

}
