package ReturningValues;

import java.util.concurrent.TimeUnit;

// emulate long running calculation
public class ValueReturningTaskB implements Runnable{

	private int a;
	private int b;
	private long sleepTime;
	private int sum;

	private static int count = 0;
	private int instanceNumber = 0;
	private String taskId;
	private ResultListner<Integer> listner;



	public ValueReturningTaskB(int a, int b,long sleepTime,ResultListner<Integer> listner) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		this.listner = listner;

		this.instanceNumber = ++count;
		this.taskId= "ValueReturningTaskB--" + instanceNumber;
	}

	public void run() {
		String currentThread =Thread.currentThread().getName();

		System.out.println("#### ["+ currentThread +"] <" + taskId + "> Starting #######" );

		System.out.println("["+ currentThread +"] <" + taskId + "> Sleeping for" + sleepTime +" milies" );

		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sum =a+b; // how to return this sum
		System.out.println(" ******  ["+ currentThread +"] <" + taskId + "> Done milies" );
		
		//adding callback here
		listner.notifyResult(sum);
	}
}
