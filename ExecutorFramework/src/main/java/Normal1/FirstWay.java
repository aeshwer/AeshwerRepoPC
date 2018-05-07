/*
 * Creating Threads normally using thread API
 */
		
package Normal1;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;

public class FirstWay {

	public static void main(String[] args) {
		System.out.println("MAIN THREAD START");
		FirstTask firstTask = new FirstTask();
		FirstTask secondTask = new FirstTask();
		System.out.println("MAIN THREAD ENDS");
		
	}

}
	
class FirstTask extends Thread
{
	private static int count= 0; 
	private int id;
	
	@Override
	public void run() {
		for(int i=10;i>0;i--) {System.out.println("<" + id+ ">"+ " TICK TICK "+i);
		
		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	FirstTask()
	{	this.id = ++count;
		this.start();
	}
}