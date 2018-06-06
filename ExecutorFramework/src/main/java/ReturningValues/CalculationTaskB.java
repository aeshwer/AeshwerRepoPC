package ReturningValues;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

// emulate long running calculation
public class CalculationTaskB implements Callable<TaskResult<String, Integer>>{

	private int a;
	private int b;
	private long sleepTime;

	private static int count = 0;
	private int instanceNumber = 0;
	private String taskId;



	public CalculationTaskB(int a, int b,long sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;

		this.instanceNumber = ++count;
		this.taskId= "CalcTaskB--" + instanceNumber;
	}

	public TaskResult call() throws Exception {
		String currentThread =Thread.currentThread().getName();

		System.out.println("#### ["+ currentThread +"] <" + taskId + "> Starting #######" );
		System.out.println("["+ currentThread +"] <" + taskId + "> Sleeping for" + sleepTime +" milies" );
		
		TimeUnit.MILLISECONDS.sleep(sleepTime);
		
		System.out.println(" ******  ["+ currentThread +"] <" + taskId + "> Done" );
		return new TaskResult<String, Integer>(taskId,a+b);
	}

}
