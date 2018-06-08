package TerminateThreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Need a non blocking task so no sleep method is used

public class LoopTaskF implements Runnable{

	private static int count= 0; 
	private int instanceNumber;
	private String taskId;
	private int Data_SIZE= 100000;
	
	LoopTaskF()
	{	this.instanceNumber = ++count;
		this.taskId= "LoopTaskF" + instanceNumber; 
	}
	
	public void run() {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println("####### [ "+ currentThread + "] <"+ taskId+ "> Starting #####");
		
		for(int i=1;;i++) 
		{
			System.out.println("<"+  currentThread  +"] < "+ taskId+ ">"+ " TICK TICK "+i);
			doSomeWork();
			if(Thread.interrupted())
			{
				System.out.println("<"+  currentThread  +"] < "+ taskId+ ">"+ " Interupted Cancelling....."+i);
				break;
			}
		}
		
		System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> Retreving 'Interupted' status  again :"+Thread.interrupted());
		System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> DONE #####");
		
	}

	// Long running calculation
	private void doSomeWork() {
		for( int i =0 ;i<2; i++) 
		{
			Collections.sort(generateDataSet());
		}
	}

	private List<Integer> generateDataSet()
	{	List<Integer> intList = new ArrayList<Integer>();
		Random randomGenerator = new Random();
	
		for( int i =0 ;i<Data_SIZE; i++) 
		{
			intList.add(randomGenerator.nextInt(Data_SIZE));
		}
		return intList;
	}
}
