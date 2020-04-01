package LeetCode_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _3Sum {

	public static class Pair {
		int one;
		int two;

		public Pair(int one, int two) {
			this.one = one;
			this.two = two;
		}
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		if (nums.length == 0)
			return new ArrayList<>(res);
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0)
					res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
				else if (sum > 0)
					k--;
				else if (sum < 0)
					j++;
			}

		}
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> threeSum = threeSum(nums);

		threeSum.forEach(outer -> {
			outer.forEach(inner -> {
				System.out.print(inner + " ");
			});
			System.out.println();
		});
	}

}
