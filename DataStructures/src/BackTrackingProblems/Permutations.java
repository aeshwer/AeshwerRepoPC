package BackTrackingProblems;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Permutations {

	public static void main(String[] args) {
		Permutations obj = new Permutations();
		int[] arr = { 1, 2, 3}; //input don't have repetition
		List<List<Integer>> result = obj.permute(arr);
		result.forEach(v -> System.out.println(v));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			resultList.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(resultList, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
