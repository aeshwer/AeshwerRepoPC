package BackTrackingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets/
//Given a set of distinct integers, nums, return all possible subsets (the power set).
public class Subset1 {

	public static void main(String[] args) {
		Subset1 obj = new Subset1();
		int[] arr = { 1, 2, 3 }; // No duplicates
		List<List<Integer>> result = obj.subsets(arr);
		result.forEach(v -> System.out.println(v));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start) {
		resultList.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(resultList, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
