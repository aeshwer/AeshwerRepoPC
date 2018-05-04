/*
 * useful where we want to fire and forget the thread since we cannot get the
 * thread refernce in the calling class 
 * 
 */
package executorFramework1;

import java.util.concurrent.TimeUnit;

public class ThirdWay {

	public static void main(String[] args) {
		System.out.println("MAIN THREAD START");
		new ThirdTask();
		new ThirdTask();  
		
		System.out.println("MAIN THREAD ENDS");
		
	}

}

class ThirdTask implements Runnable
{
	private static int count= 0; 
	private int id;
	
	public void run() {
		for(int i=10;i>0;i--) {System.out.println("<" + id+ ">"+ " TICK TICK "+i);
		
		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	ThirdTask()
	{	this.id = ++count;
		new Thread(this).start();
	}
}