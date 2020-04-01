package LeetCode_Medium;

import java.util.Arrays;

public class _3SumClosest {

	public static int threeSumClosest(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

		int[] nums = { -3, -2, -5, 3, -4 };
		System.out.println(threeSumClosest(nums, -1));

	}

}
