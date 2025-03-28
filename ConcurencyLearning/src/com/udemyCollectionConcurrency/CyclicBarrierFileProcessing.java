package com.udemyCollectionConcurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierFileProcessing {

	public static class FileProcessor implements Runnable {

		private int chunkId;
		private CyclicBarrier barrier;

		public FileProcessor(int chunkId, CyclicBarrier barrier) {
			this.chunkId = chunkId;
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				System.out.println("Processing file chunk: " + chunkId);
				Thread.sleep(2000); // Simulate file processing

				System.out.println("Finished processing chunk: " + chunkId);

				// Wait until all threads reach this point
				barrier.await();

				System.out.println("Chunk " + chunkId + " merging results...");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		int numThreads = Runtime.getRuntime().availableProcessors();
		CyclicBarrier barrier = new CyclicBarrier(numThreads,
				() -> System.out.println("✅ All chunks processed. Merging results..."));

		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		for (int i = 0; i < numThreads; i++) {
			executor.submit(new FileProcessor(i, barrier));
		}
		executor.shutdown();
	}
}
