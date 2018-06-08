package TerminateThreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//Need a task that blocks

public class LoopTaskG implements Runnable{

	private static int count= 0; 
	private int instanceNumber;
	private String taskId;
	
	LoopTaskG()
	{	this.instanceNumber = ++count;
		this.taskId= "LoopTaskG" + instanceNumber; 
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
				System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> SLEEP INTERRUPTED ...cancelling......");
				break;   // break and terminate the thread
			}
		}
		
		System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> DONE #####");
		
	}

}
