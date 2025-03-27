package com.udemy.ForkJoinAlgo;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFind extends RecursiveTask<Integer>{

	private int nums[];
	private int highIndex;
	private int lowIndex;
	
	
	public ParallelMaxFind(int[] nums, int lowIndex, int highIndex) {
		this.nums = nums;
		this.highIndex = highIndex;
		this.lowIndex = lowIndex;
	}


	@Override
	protected Integer compute() {
		if((highIndex-lowIndex) < App.THRESHOLD)
			{
			return sequentialMaxFinding();
			}
		else
		{
			int middleIndex = (lowIndex+highIndex)/2;
			ParallelMaxFind parallelMaxFind1 = new ParallelMaxFind(nums, lowIndex, middleIndex);
			ParallelMaxFind parallelMaxFind2 = new ParallelMaxFind(nums, middleIndex+1, highIndex);
			
			//start and Waits for all tasks to complete before returning.
			invokeAll(parallelMaxFind1,parallelMaxFind2);
			return Math.max(parallelMaxFind1.join(), parallelMaxFind1.join());
					
		}
				
	}
	
	private int sequentialMaxFinding() {
		int max = nums[lowIndex];
		
		for(int i=lowIndex+1;i< highIndex; i++)
		{
			if(nums[i]> max)
			{
				max= nums[i];
			}
		}
		return max;
	}
}
	