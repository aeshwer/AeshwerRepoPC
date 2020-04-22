package LeetCode_Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
/*
 * Given an array of integers and an integer k, you need to find the total number 
 * of continuous subarrays whose sum equals to k
 */
class SubarraySumEqualsK {

	public static int subarraySum(int[] nums, int k) {
		int sum = 0;
		int result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1); //This is our base case,ie sum zero and its count freq

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 5, 2 };
		System.out.println("INPUT - " + Arrays.toString(nums));
		System.out.println(subarraySum(nums, 2));
	}
}
