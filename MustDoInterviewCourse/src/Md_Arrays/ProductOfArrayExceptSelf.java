package Md_Arrays;

import java.util.Arrays;

/*
 * Given an array nums of n integers where n > 1,  
 * return an array output such that output[i] is equal to the product 
 * of all the elements of nums except nums[i].
 */
//NOTE: : Please solve it without division and in O(n). Follow up - constant space

public class ProductOfArrayExceptSelf {

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		// Calculate lefts and store in res.
		int left = 1;
		for (int i = 0; i < n; i++) {
			if (i > 0)
				left = left * nums[i - 1];
			res[i] = left;
		}
		// Calculate rights and the product from the end of the array.
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (i < n - 1)
				right = right * nums[i + 1];
			res[i] *= right;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 }; // 24,12,8,6
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}
}
