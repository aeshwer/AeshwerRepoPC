package LeetCode_Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/
public class Combinations {

	public static List<List<Integer>> combine(int n, int k) {
		if (k == 0)
			return new ArrayList<>();

		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		combineUtil(n, k, resultList, res, 1);
		return resultList;
	}

	public static void combineUtil(int n, int k, List<List<Integer>> resultList, List<Integer> res, int start) {
		if (res.size() == k) {
			resultList.add(new ArrayList<>(res));
			return;
		}
		for (int i = start; i <= n; i++) {
			res.add(i);
			combineUtil(n, k, resultList, res, i + 1);
			res.remove(res.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> combine = combine(4, 2);
		combine.forEach(list -> {
			list.forEach(val -> {
				System.out.print(val + " ");
			});
			System.out.println();
		});
	}
}
