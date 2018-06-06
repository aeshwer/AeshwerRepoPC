package ReturningValues;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

// emulate long running calculation
public class CalculationTaskA implements Callable<Integer>{

	private int a;
	private int b;
	private long sleepTime;

	private static int count = 0;
	private int instanceNumber = 0;
	private String taskId;



	public CalculationTaskA(int a, int b,long sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;

		this.instanceNumber = ++count;
		this.taskId= "CalcTaskA--" + instanceNumber;
	}

	public Integer call() throws Exception {
		String currentThread =Thread.currentThread().getName();

		System.out.println("#### ["+ currentThread +"] <" + taskId + "> Starting #######" );
		System.out.println("["+ currentThread +"] <" + taskId + "> Sleeping for" + sleepTime +" milies" );
		
		TimeUnit.MILLISECONDS.sleep(sleepTime);
		
		System.out.println(" ******  ["+ currentThread +"] <" + taskId + "> Done" );
		return (a+b);
	}

}
