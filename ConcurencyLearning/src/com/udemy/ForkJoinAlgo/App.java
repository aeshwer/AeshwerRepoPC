package com.udemy.ForkJoinAlgo;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import com.udemy.paralleAlgo.ParallelMergeSort;

public class App {

	public static int THRESHOLD = 0;
	
	public static void main(String[] args) {
		
		int nums[] = initializeNums();
		//int nums[] = {2,3,4,4,132,43,13,42,223,4,34,3 };
		
		THRESHOLD = nums.length /(Runtime.getRuntime().availableProcessors());
		
		// run the algorithm and time how long it takes ======SEQUENTIAL
		SequentialMaxFind sequentialMaxFind = new SequentialMaxFind(nums, nums.length);
		long startTime1 = System.currentTimeMillis();
		System.out.println("MAX IS : " + sequentialMaxFind.SequentialMaxFind());
		long endTime1 = System.currentTimeMillis();
		System.out.printf("Time taken in SEQUENTIAL =>  %6d ms \n", endTime1 - startTime1);
		
		
		// run the algorithm and time how long it takes ======PARALLEL
		ParallelMaxFind parallelMaxFind = new ParallelMaxFind(nums,0, nums.length);
		ForkJoinPool forkJoinPool =  new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		long startTime2 = System.currentTimeMillis();
		System.out.println("MAX IS : " + forkJoinPool.invoke(parallelMaxFind));
		long endTime2 = System.currentTimeMillis();
		System.out.printf("Time taken in Parallel =>  %6d ms \n", endTime2 - startTime2);
		
				
		
	}

	private static int[] initializeNums() {
		Random random = new Random();
		int[] a = new int[10000000];
		for (int i = 0; i < 10000000; i++) {
			a[i] = random.nextInt(10000000);			
		}
		return a;
	}
}
