package com.udemyCollectionConcurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class working implements Runnable
{
	private int id;
	private CyclicBarrier cyclicBarrier;
	
	public working(int id , CyclicBarrier cyclicBarrier)
	{
		this.id = id;
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		doWorks();
	}
	
	private void doWorks()
	{
		System.out.println("Thread with id : "+ id + "Start Working");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread with id : "+ id + "Finished");
		
		try {
			cyclicBarrier.await();
			System.out.println("After await"); // this step is executed after the threads are relased from the cyclic barrier
		} catch (InterruptedException | BrokenBarrierException e) {
 			e.printStackTrace();
		}
		
	}
	@Override
	public String toString(){return ""+this.id;}
}

public class CyclicBarrierLearn {

	public static void main(String[] args) {
		
		ExecutorService executerService = Executors.newFixedThreadPool(5);
		// this runnable is called when the last last thread is executed
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("All task finished");
			}
		});
		// create five tasks
		for (int i = 0; i < 5; i++) {
			executerService.submit(new working(i, cyclicBarrier));
			}
		
			executerService.shutdown();
	}

}
