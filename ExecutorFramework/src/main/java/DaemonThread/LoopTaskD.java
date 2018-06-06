package DaemonThread;

import java.util.concurrent.TimeUnit;

public class LoopTaskD implements Runnable{

	private static int count= 0; 
	private int instanceNumber;
	private String taskId;
	private Integer sleepTime;
	
	public LoopTaskD(Integer sleepTime)
	{	this.sleepTime = sleepTime;
		this.instanceNumber = ++count;
		this.taskId= "LoopTaskB " + instanceNumber; 
	}
	
	
	public void run() {
		boolean isRunningInDaemonThread = Thread.currentThread().isDaemon();
		String threadType =isRunningInDaemonThread ? "DAEMON" : "USER";
		String currentThread = Thread.currentThread().getName();
		
		System.out.println("#######  ["+ currentThread +"  ,"+ threadType+ "] <"+ taskId+ "> Starting #####");
		
		for(int i=5;i>0;i--) 
		{System.out.println("["+  currentThread +"  ," +threadType +"] <"+ taskId+ ">"+ " TICK TICK "+i);
		
		try {
			TimeUnit.MILLISECONDS.sleep((long) (Math.random()*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
		System.out.println("####### ["+   currentThread +", " +threadType+" ] <"+ taskId+ "> DONE #####");
	}
	
}
