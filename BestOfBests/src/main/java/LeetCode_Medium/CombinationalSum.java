package LeetCode_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationalSum {

	public static void main(String[] args) {
		CombinationalSum obj = new CombinationalSum();
		int target = 7;
		int[] arr = { 2, 3, 6,7 };
		List<List<Integer>> result = obj.combinationSumSolver(arr, target);
		result.forEach( v -> System.out.println(v));
	}

	public List<List<Integer>> combinationSumSolver(int[] nums, int target) {
		List<List<Integer>> finalResultList = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(finalResultList, new ArrayList<>(), nums, target, 0);
		return finalResultList;
	}

	private void backtrack(List<List<Integer>> finalResultList, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			finalResultList.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(finalResultList, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
