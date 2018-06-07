package CheckingIfThreadIsAlive;

import java.util.concurrent.TimeUnit;

import namingTheThread.LoopTaskC;

public class NormalWayCheck {

	public static void main(String[] args) {
		
	String currentThread = Thread.currentThread().getName(); 
	
	System.out.println(currentThread + "Main Thread Starts Here");
	
	Thread t1=new Thread(new LoopTaskC(), "Thread-1");
	Thread t2=new Thread(new LoopTaskC(), "Thread-2");
	
	boolean isAlive1 = t1.isAlive();
	boolean isAlive2 = t2.isAlive();
	
	System.out.println("#######  ["+ currentThread + "]"+ " Before Starting is :" + t1.getName()+" is Alive " + isAlive1);
	System.out.println("#######  ["+ currentThread + "]"+ " Before Starting is :" + t2.getName()+" is Alive " + isAlive2);
	
	t1.start();
	t2.start();
	
	while(true) 
	{
		try {
			TimeUnit.MILLISECONDS.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isAlive1 =t1.isAlive();
		isAlive2 =t2.isAlive();
		
		System.out.println("#######  ["+ currentThread + "]"+ " Before Starting is :" + t1.getName()+" is Alive " + isAlive1);
		System.out.println("#######  ["+ currentThread + "]"+ " Before Starting is :" + t2.getName()+" is Alive " + isAlive2);

		if(!isAlive1 && !isAlive2)
		{
			break; //  break when both threads are no longer alive
		}
	}
	
	System.out.println(currentThread + "Main Thread ENDS Here");
	}
}
