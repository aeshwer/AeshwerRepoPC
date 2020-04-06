package Company_Solution;

import java.util.HashMap;
import java.util.Map;

public class AqrSolution {
	public static void main(String[] args) {
		int cutCost1 = 1, price1 = 10;
		int[] nums1 = { 26, 59, 103 };
		int cutCost2 = 100, price2 = 10;
		int[] nums2 = { 26, 59, 103 };
		int cutCost3 = 1, price3 = 10;
		int[] nums3 = { 30, 59, 110 };
		// maxProfit(nums1, cutCost1, price1);
		// maxProfit(nums2, cutCost2, price2);
		// maxProfit(nums3, cutCost3, price3);
		int cutCost4 = 1, price4 = 1000;
		int[] nums4 = { 2, 8000, 9999, 7023, 2312, 2323, 4545, 7654, 2235, 1234, 10000, 11, 22, 3331, 3313 };
		maxProfit(nums4, cutCost4, price4);
	}

	private static void maxProfit(int[] nums, int cutCost, int price) {
		int maxLength = 0;
		for (int n : nums)
			maxLength = Math.max(n, maxLength);

		long start = System.nanoTime();
		System.out.println(helper(nums, cutCost, price, 0, maxLength, new HashMap<>()));
		long end = System.nanoTime();
		System.out.println("For Method 1- " + (start - end) + " nanoseconds");

		long start1 = System.nanoTime();
		System.out.println(helper1(nums, cutCost, price, maxLength));
		long end1 = System.nanoTime();
		System.out.println("For Method 2- " + (start1 - end1) + " nanoseconds");

	}

	// correct solution O(n)
	private static int helper1(int[] nums, int cutCost, int price, int maxLength) {
		int max = 0;
		for (int i = 1; i <= maxLength; i++) {
			max = Math.max(getCost(nums, cutCost, price, i), max);
		}
		return max;

	}

	// Non recommended
	private static int helper(int[] nums, int cutCost, int price, int l, int r, Map<String, Integer> memo) {
		int res = 0;
		if (l >= r)
			return res;
		if (memo.containsKey(l + "_" + r))
			return memo.get(l + "_" + r);
		int rangeL = l, rangeR = r;
		while (l < r) {
			int m1 = l + (r - l) / 2;
			int m2 = m1 + 1;
			if (getCost(nums, cutCost, price, m1) > getCost(nums, cutCost, price, m2))
				r = m1;
			else
				l = m2;
		}
		int resR = helper(nums, cutCost, price, l + 1, rangeR, memo);
		int resL = helper(nums, cutCost, price, rangeL, l - 1, memo);
		res = Math.max(getCost(nums, cutCost, price, l), Math.max(res, Math.max(resL, resR)));
		memo.put(rangeL + "_" + rangeR, res);
		return res;
	}

	static int getCost(int[] nums, int cutCost, int price, int length) {
		int sellingPrice = 0;
		int costPrice = 0;
		if (length == 0) {
			return Integer.MIN_VALUE;
		}
		for (int i = 0; i < nums.length; i++) {
			int numOfRods = nums[i] / length;
			int numOfCuts = nums[i] % length == 0 ? numOfRods - 1 : numOfRods;
			sellingPrice = sellingPrice + (numOfRods * length * price);
			costPrice = costPrice + (numOfCuts * cutCost);
		}

		int profit = sellingPrice - costPrice;
		return profit;
	}
}
