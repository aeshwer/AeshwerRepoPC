 package com.udemyCollectionConcurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// don't care about the syncronization since that is managed by the blocking queue internally 
class FirstWorker implements Runnable{

	private BlockingQueue<Integer> blockingQueue ;
	
	public  FirstWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue =  blockingQueue;
	}
	@Override
	public void run() {
		
		int counter = 0;
		while(true){
			try {
				System.out.println("Putting Item to Queue "+ counter);
				blockingQueue.put(counter);
				counter++;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
} 

class SecondWorker implements Runnable{

	private BlockingQueue<Integer> blockingQueue ;
	
	public  SecondWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue =  blockingQueue;
	}
	@Override
	public void run() {
		while(true){
			try {
				int num = blockingQueue.take();
				System.out.println("Taking Item from Queue "+ num);
				Thread.sleep(4300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
} 
public class BlockQueueLearn {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		FirstWorker firstWorker = new FirstWorker(queue);
		SecondWorker secondWorker = new SecondWorker(queue);
		
		new Thread(firstWorker).start();
		new Thread(secondWorker).start();
		
	}
}
