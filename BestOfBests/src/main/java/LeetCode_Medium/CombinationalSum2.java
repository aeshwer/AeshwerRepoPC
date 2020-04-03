package LeetCode_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationalSum2 {

	public static void main(String[] args) {
		CombinationalSum2 obj = new CombinationalSum2();
		int target = 8;
		int[] arr = { 2, 3, 5 };
		//[10,1,2,7,6,1,5]
		List<List<Integer>> result = obj.combinationSumSolver(arr, target);
		result.forEach(v -> System.out.println(v));
	}

	public List<List<Integer>> combinationSumSolver(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> finalResultList, List<Integer> tempList, int[] nums, int remain,
			int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			finalResultList.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				if (i > start && nums[i] == nums[i - 1])
					continue; // skip duplicates
				tempList.add(nums[i]);
				backtrack(finalResultList, tempList, nums, remain - nums[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
