package com.udemyConcurreny;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Worker 
{
	private Lock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void produce() throws InterruptedException
	{
		lock.lock();     // reentrant lock used 
		System.out.println("Produer Method");
		condition.await();
		System.out.println("Produer again");
		lock.unlock();
		
		
	}
	
	public void consume() throws InterruptedException
	{
		lock.lock();     // reentrant lock used 
		Thread.sleep(1000);
		System.out.println("Consumer Method");
		condition.signal();
		lock.unlock();
		
	}
	 
	
	
}
	
public class ProducerConsumerWithLOck {
	public static void main(String[] args) {
	
	Worker process = new Worker(); 
	Thread t1 = new Thread(new Runnable(){
		@Override
		public void run() 
		{
			try {
				process.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	,"Producer-Thread") ;
	
	Thread t2 = new Thread(new Runnable(){
		@Override
		public void run() 
		{
			try {
				process.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	,"Consumer-Thread");
	

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