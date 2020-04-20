package LeetCode_Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		resultList.add(new ArrayList<>());
		if (nums == null || nums.length == 0)
			return resultList;

		List<Integer> res = new ArrayList<>();
		int maxSize = nums.length;

		for (int i = 1; i <= maxSize; i++) {
			subsetsUtil(nums, resultList, res, 0, i);
		}
		return resultList;
	}

	public static void subsetsUtil(int[] nums, List<List<Integer>> resultList, List<Integer> res, int start,
			int maxSize) {
		if (res.size() == maxSize) {
			resultList.add(new ArrayList<>(res));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			res.add(nums[i]);
			subsetsUtil(nums, resultList, res, i + 1, maxSize);
			res.remove(res.size() - 1);
		}
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };
		List<List<Integer>> combine = subsets(nums);
		combine.forEach(list -> {
			list.forEach(val -> {
				System.out.print(val + " ");
			});
			System.out.println();
		});

	}
}
