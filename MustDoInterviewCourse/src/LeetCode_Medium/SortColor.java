package LeetCode_Medium;

import java.util.Arrays;

public class SortColor {

	public static void sortColors(int[] nums) {

		int low = 0;
		int high = nums.length - 1;
		int mid = 0;
		int temp = 0;

		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				// swap value with zeros pointer
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				// swap value with twos pointer
				temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;
				break;
			}

		}
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		sortColors(nums);// 0,0,1,1,2,2
	}
}
