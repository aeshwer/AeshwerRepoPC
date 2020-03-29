package Md_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationalsumUnique {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		combinationSumUtil(candidates, resultList, res, target, 0);
		return resultList;
	}

	private void combinationSumUtil(int[] candidates, List<List<Integer>> resultList, List<Integer> res, int target,
			int start) {

		if (target < 0) {
			return;
		}
		if (target == 0) {
			resultList.add(new ArrayList<Integer>(res));
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				if (target > 0) {
					res.add(candidates[i]);
					combinationSumUtil(candidates, resultList, res, target - candidates[i], i);
					res.remove(res.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		CombinationalsumUnique obj = new CombinationalsumUnique();
		List<List<Integer>> combinationSum = obj.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		combinationSum.forEach(l -> {
			l.forEach(out -> {
				System.out.print(out + " ");
			});
			System.out.println();
		});

	}
}
