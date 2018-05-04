package executorFramework1;

import java.util.concurrent.TimeUnit;

public class FourthWay {


	public static void main(String[] args) {
		System.out.println("MAIN THREAD START");
		new Thread(new FourthTask()).start();
		Thread t= new Thread(new FourthTask()); // thread object created here
		t.start();
		
		System.out.println("MAIN THREAD ENDS");
		
	}

}


class FourthTask implements Runnable
{
	private static int count= 0; 
	private int id;
	;
	public void run() {
		for(int i=10;i>0;i--) {System.out.println("<" + id+ ">"+ " TICK TICK "+i);
		
		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	FourthTask()
	{	this.id = ++count;
	}
}