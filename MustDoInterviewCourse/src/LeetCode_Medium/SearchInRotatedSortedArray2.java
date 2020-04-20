package LeetCode_Medium;

import java.util.Arrays;

public class SearchInRotatedSortedArray2 {

	// O(n)
	// Note : O(logn) is not possible
	public static boolean search(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;
		int mid = -1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return true;
			}
			// If we know for sure right side is sorted or left side is unsorted
			if (nums[mid] < nums[right] || nums[mid] < nums[left]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
				// If we know for sure left side is sorted or right side is unsorted
			} else if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
				// If we get here, that means nums[start] == nums[mid] == nums[end], then
				// shifting out
				// any of the two sides won't change the result but can help remove duplicate
				// from
				// consideration, here we just use end-- but left++ works too
			} else {
				right--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1 };
		System.out.println(Arrays.toString(nums));
		System.out.println(search(nums, 3));
	}
}
