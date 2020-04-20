package LeetCode_Medium;

import java.util.Arrays;

public class SearchInRotatedArray {

	public static int search(int[] nums, int target) {
		int n = nums.length;
		int low = 0;
		int high = n - 1;
		// find the index of the smallest value using binary search.
		// Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
		// Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would
		// have been terminated.
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[high])
				low = mid + 1;
			else
				high = mid;
		}
		// lo==hi is the index of the smallest value and also the number of places
		// rotated.
		int rot = low;
		low = 0;
		high = n - 1;
		// The usual binary search and accounting for rotation.
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int realmid = (mid + rot) % n;
			if (nums[realmid] == target)
				return realmid;
			if (nums[realmid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(Arrays.toString(arr));
		System.out.println(search(arr, 0));
	}
}
