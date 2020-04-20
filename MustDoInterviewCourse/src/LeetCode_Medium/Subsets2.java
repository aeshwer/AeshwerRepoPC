package LeetCode_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/subsets-ii/
public class Subsets2 {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Set<List<Integer>> resultList = new HashSet<>();
		resultList.add(new ArrayList<>());
		if (nums == null || nums.length == 0)
			return resultList.stream().collect(Collectors.toList());

		Arrays.sort(nums);
		List<Integer> res = new ArrayList<>();
		int maxSize = nums.length;

		for (int i = 1; i <= maxSize; i++) {
			subsetsUtil(nums, resultList, res, 0, i);
		}
		return resultList.stream().collect(Collectors.toList());
	}

	public static void subsetsUtil(int[] nums, Set<List<Integer>> resultList, List<Integer> res, int start,
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

		int[] nums = { 1, 2, 2 };
		List<List<Integer>> combine = subsetsWithDup(nums);
		combine.forEach(list -> {
			list.forEach(val -> {
				System.out.print(val + " ");
			});
			System.out.println();
		});

	}
}
