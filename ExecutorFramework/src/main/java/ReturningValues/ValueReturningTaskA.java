package ReturningValues;

import java.util.concurrent.TimeUnit;

// emulate long running calculation
public class ValueReturningTaskA implements Runnable{

	private int a;
	private int b;
	private long sleepTime;
	private long sum;
	
	private static int count = 0;
	private int instanceNumber = 0;
	private String taskId;
	
	private volatile boolean done;
	


	public ValueReturningTaskA(int a, int b,long sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		
		this.instanceNumber = ++count;
		this.taskId= "ValueReturningTaskA--" + instanceNumber;
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

		done=true;
		synchronized (this) {
			System.out.println("["+ currentThread +"] <" + taskId + "> Notified ***" );
			this.notifyAll();
		}
		
	}
	
	public int getSum() 
	{
		if(!done) {
			synchronized (this) {
				try {
					this.wait();
					System.out.println("["+ Thread.currentThread().getName() +"] <" + taskId + "> WAITING" );
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		return (int) sum;
	}
	
	

}
