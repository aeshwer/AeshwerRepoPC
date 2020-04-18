package LeetCode_Medium;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesFromSortedArray2 {

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;

		int index = 0;
		int previous = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {

			if (previous == nums[i]) {
				continue;
			}

			if (previous != nums[i] && nums[i] == nums[i - 1]) {
				nums[++index] = nums[i];
				previous = nums[i];
				continue;
			}

			nums[++index] = nums[i];

		}
		System.out.println("Output" + Arrays.toString(nums));
		return ++index;

	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println("Input " + Arrays.toString(nums));
		System.out.println(removeDuplicates(nums));

	}
}
