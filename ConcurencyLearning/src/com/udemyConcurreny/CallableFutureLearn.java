package com.udemyConcurreny;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class worker4 implements Callable<String> {

	private int id;

	// constructor
	public worker4(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Id" + id;
	}

}

public class CallableFutureLearn {

	public static void main(String[] args) {

		ExecutorService executerService = Executors.newFixedThreadPool(2); // .. used a fixed number of threads
		List<Future<String>> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			// created five task here
			Future<String> future = executerService.submit(new worker4(i)); // string returned wrapped around a future
			list.add(future);
		}

		for (Future<String> future : list) {
			try {
				//Tasks are executed in parallel but results are printed sequentially due to get().
				//Calling future.get() blocks the current thread until the result is ready.
				System.out.println(future.get()); // get function returns us the output id
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		executerService.shutdown();

	}
}
