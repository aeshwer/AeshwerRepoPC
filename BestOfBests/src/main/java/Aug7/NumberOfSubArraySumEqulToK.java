//https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
package Aug7;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraySumEqulToK {

	// Function to find number of subarrays with sum exactly equal to k
	static int findSubarraySum(int arr[], int n, int k) {
		// HashMap to store number of subarrays
		// starting from index zero having particular value of sum.
		Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();

		int res = 0;

		// Sum of elements so far.
		int sum = 0;

		for (int i = 0; i < n; i++) {

			// Add current element to sum so far.
			sum += arr[i];

			// If currsum is equal to desired sum,
			// then a new subarray is found. So increase count of subarrays.
			if (sum == k)
				res++;

			// currsum exceeds given sum by (currsum - sum). Find number of
			// subarrays having this sum and exclude those subarrays
			// from currsum by increasing count by same amount.
			if (lookup.containsKey(sum - k))
				res += lookup.get(sum - k);

			// Add currsum value to count of different values of sum.
			if (!lookup.containsKey(sum))
				lookup.put(sum, 1);
			else {
				lookup.put(sum, lookup.get(sum) + 1);
			}

		}
		return res;
	}

	public static void main(String[] args) {

		int arr[] = { 10, 2, -2, -20, 10 };
		int sum = -10;
		int n = arr.length;
		System.out.println(findSubarraySum(arr, n, sum));
	}
}
