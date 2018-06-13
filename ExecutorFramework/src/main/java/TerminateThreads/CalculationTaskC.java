package TerminateThreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

//Need a non blocking task so no sleep method is used

public class CalculationTaskC implements Callable<Long>{

	private static int count= 0; 
	private int instanceNumber;
	private String taskId;
	private int Data_SIZE= 100000;
	
	private boolean isThreadInterupted= false;
	
	CalculationTaskC()
	{	this.instanceNumber = ++count;
		this.taskId= "CalculationTaskC" + instanceNumber; 
	}
	
	public Long  call() throws Exception {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println("####### [ "+ currentThread + "] <"+ taskId+ "> Starting #####");
		
		long totalTime = 0;
		
		for(int i=0;i<1000;i++) 
		{
			System.out.println("<"+  currentThread  +"] < "+ taskId+ ">"+ " CURRENT RUNNING AVG TIME"+(i==0 ? 0 :totalTime/(2*i)));
			long SupertotalTime= doSomeWork();
			SupertotalTime += totalTime;
			if(Thread.interrupted())
			{
				System.out.println("<"+  currentThread  +"] < "+ taskId+ ">"+ " Interupted Cancelling....."+i);
				break;
			}
		}
		
		System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> Retreving 'Interupted' status  again :"+Thread.interrupted());
		System.out.println("####### [ "+   currentThread + "] <"+ taskId+ "> DONE #####");
		
		return isThreadInterupted ? -1 : totalTime/(2*1000);
		
	}

	// Long running calculation
	private long doSomeWork() {
		long startTime = System.currentTimeMillis();
		
		for( int i =0 ;i<2; i++) 
		{
			Collections.sort(generateDataSet());
		}
		
		return System.currentTimeMillis() - startTime;
				
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
