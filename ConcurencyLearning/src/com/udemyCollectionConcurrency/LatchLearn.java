package com.udemyCollectionConcurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class work implements Runnable
{
	private int id;
	private CountDownLatch CountDownLatch;
	
	public work(int id, CountDownLatch countDownLatch)
	{ 
		this.id = id;
		this.CountDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		doWork();	
		CountDownLatch.countDown();  // decrement value
	}
	
	private void doWork()
	{
		System.out.println("Thread with id : "+ id + "Start Working");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class LatchLearn {

	public static void main(String[] args) {
		
		ExecutorService executerService = Executors.newSingleThreadExecutor();
		CountDownLatch latch = new CountDownLatch(5);
		
		// create five tasks
		for (int i = 0; i < 5; i++) {
			executerService.submit(new work(i, latch));
			try {
				latch.await();   // wait for ever single worker to finish  and until countDown has been called five times
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("All the prerequisites is done");
			executerService.shutdown();
		}
		
	}
}
