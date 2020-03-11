package com.udemyConcurreny;

class  Processor{
	
	public void produce() throws InterruptedException
	{
		synchronized (this) {    // object level lock 
			System.out.println("Producer");
			wait(); // thread 1 hands over the lock to other threads which use the same lock, Thread 2 in our case
			System.out.println("Producer Again ");
		}
	}
	
	public void consume() throws InterruptedException
	{
		Thread.sleep(1000);  // this is 1 second sleep which ensure thread 1 acquire the intrinsic lock
		synchronized (this){
			System.out.println("Consumer");
			notify();  // this notifies the waiting thread and tell its time to wake  but it does complete this syn method first
		}
		
	}
	
}

public class WaitAndNotify {
	public static void main(String[] args) {
		
		Processor processor = new Processor(); 
		Thread t1 = new Thread(new Runnable(){
			 
			@Override
			public void run() 
			{
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		);
		
		Thread t2 = new Thread(new Runnable(){
			 
			@Override
			public void run() 
			{
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	} 
}
