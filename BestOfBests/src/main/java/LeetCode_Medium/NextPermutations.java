package LeetCode_Medium;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/submissions/
public class NextPermutations {

	public static void nextPermutation(int[] nums) {

		int index = Integer.MAX_VALUE;
		// find the point of change
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				index = i - 1;
				break;
			}
		}
		// corner case - if the number is max
		if (index == Integer.MAX_VALUE) {
			Arrays.sort(nums);
			return;
		}

		// compare and swap at reversal point
		for (int i = nums.length - 1; i > index; i--) {
			if (nums[i] > nums[index]) {
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
				break;
			}
		}

		// Reverse all after index+1;
		int start = index + 1;
		int end = nums.length - 1;
		int looperCount = (end - start + 1) / 2;

		while (looperCount-- > 0) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}

	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 1, 9, 7, 3, 2 }; // [4,2,1,3,7,9]
		int[] nums2 = { 3, 1, 7, 9, 2 }; // [3,1,9,2,7]
		int[] nums3 = { 3, 2, 1 }; // [3,1,2]
		nextPermutation(nums1);
		nextPermutation(nums2);
		nextPermutation(nums3);
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		System.out.println(Arrays.toString(nums3));
	}
}
