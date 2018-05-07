package ExecutorFramework1;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable{

	private static int count= 0; 
	private int id;
	public void run() {
		System.out.println("####### Task" + id+ "Starting #####");
		
		for(int i=10;i>0;i--) 
		{System.out.println("<" + id+ ">"+ " TICK TICK "+i);
		
		try {
			TimeUnit.MILLISECONDS.sleep((long) (Math.random()*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
		System.out.println("####### Task" + id+ "DONE #####");
	}
	
	LoopTaskA()
	{	this.id = ++count;
	}
}
