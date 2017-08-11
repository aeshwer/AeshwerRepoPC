package com.udemyConcurreny;

// use of the volatile keyword(read from main memory) vs non volatile(read from cache)

class worker implements Runnable
{

	//private boolean isTerminated = false;  //read from cache .. it can happen that cpu may cache this  boolean and them setter of this wont affect this value and it becomes a infinte loop
	private volatile boolean isTerminated = false;  //read from main memory ... force java to read from main memory
	@Override
	public void run() {

		while(!isTerminated)
		{
			System.out.println("Hello from worker class");
			try{
				Thread.sleep(300);
			}catch(InterruptedException e)
			{e.printStackTrace();} 
		}
	}	
	
	public boolean isTerminated() {
		return isTerminated;
	}
	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
}

public class App2 {

	public static void main(String[] args) {
		
		worker wk = new worker();
		Thread t1 = new Thread(wk);
		t1.start();
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{e.printStackTrace();}
		
		wk.setTerminated(true);
		System.out.println("Finished");
	}

}
