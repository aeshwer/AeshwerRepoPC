package LeetCode_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _4sum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		Set<List<Integer>> res = new HashSet<>();
		if (nums.length == 0)
			return new ArrayList<>(res);
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));

		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int k = j + 1;
				int l = nums.length - 1;
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum == target)
						res.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[l--]));
					else if (sum > target)
						l--;
					else if (sum < target)
						k++;
				}
			}

		}
		return new ArrayList<>(res);

	}

	public static void main(String[] args) {

		int[] nums = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> fourSum = fourSum(nums, 0);

		fourSum.forEach(outer -> {
			outer.forEach(inner -> {
				System.out.print(inner + " ");
			});
			System.out.println();
		});

	}
}
