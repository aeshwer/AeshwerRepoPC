/*
 * thread started from calling code rather then task contructor : gives more control to 
 * calling code when to start and stop thread
 */
package executorFramework1;


import java.util.concurrent.TimeUnit;

public class SecondWay {
	
	public static void main(String[] args) {
		System.out.println("MAIN THREAD START");
		new SecondTask().start();;
		Thread t = new SecondTask();  // used polymorphism
		t.start();
		
		System.out.println("MAIN THREAD ENDS");
		
	}
}


class SecondTask extends Thread
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
	
	SecondTask()
	{	this.id = ++count;
	}
}