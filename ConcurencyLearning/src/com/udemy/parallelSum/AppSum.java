package com.udemy.parallelSum;

import java.util.Random;

public class AppSum {

	public static void main(String[] args) {
		
		Random random = new Random();
		int numberOfThreads  = Runtime.getRuntime().availableProcessors();
		System.out.println("No of core: "+	 numberOfThreads);
		
		SequentialSum sequentialSum = new SequentialSum();
		ParalleSum paralleSum = new ParalleSum(numberOfThreads);
		
		int nums[]=new int[100000000];
		
		for(int i =0; i<nums.length; i++)
		{
			nums[i] = random.nextInt(100000000);
		}
		
		// Sequential 
		long start1 = System.currentTimeMillis();
		System.out.println("Sum by Sequential is  : "+ sequentialSum.sum(nums));
		long end1 = System.currentTimeMillis();
		System.out.printf("Time taken in sequential =>  %6d ms \n", end1 - start1);
		
		// Parallel
		long start2 = System.currentTimeMillis();
		System.out.println("Sum by parallel is  : "+ paralleSum.sum(nums));
		long end2 = System.currentTimeMillis();
		System.out.printf("Time taken in parallel =>  %6d ms \n", end2 - start2);
	}
}
