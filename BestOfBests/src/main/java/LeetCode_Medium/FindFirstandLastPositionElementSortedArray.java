package LeetCode_Medium;

import java.util.Arrays;

public class FindFirstandLastPositionElementSortedArray {
	public static int[] searchRange(int[] nums, int target) {

		int[] res = new int[2];
		Arrays.fill(res, -1);
		if (nums == null || nums.length == 0)
			return res;
		// find first occurance
		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				end = mid;
				if (mid - 1 >= 0 && nums[mid - 1] == target) {
					end--;
				} else {
					break;
				}
			}

			if (nums[mid] < target) {
				start = mid + 1;
			}
			if (nums[mid] > target) {
				end = mid - 1;
			}
		}

		res[0] = end >= 0 && nums[end] == target ? end : -1;

		// Find last occurance
		start = 0;
		end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				start = mid;
				if (mid + 1 <= nums.length - 1 && nums[mid + 1] == target) {
					start++;
				} else {
					break;
				}
			}

			if (nums[mid] < target) {
				start = mid + 1;
			}
			if (nums[mid] > target) {
				end = mid - 1;
			}
		}

		res[1] = start < nums.length && nums[start] == target ? start : -1;
		return res;

	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,8,8,8,8,8,9};
		System.out.println(Arrays.toString(arr));
		int[] res = searchRange(arr, 8);
		System.out.println(res[0] + " " + res[1]);
	}
}
