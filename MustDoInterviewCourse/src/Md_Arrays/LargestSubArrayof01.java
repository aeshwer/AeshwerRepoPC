package Md_Arrays;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArrayof01 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int N = sc.nextInt();
			int a[] = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
			}

			LargestSubArrayof01 g = new LargestSubArrayof01();
			int n = g.maxLen(a);

			System.out.println(n);

			T--;
		}
	}

	/*
	 * This is a function problem.You only need to complete the function given below
	 */
	/* You are required to complete this method */
	int maxLen(int[] arr) {
		// replace 0's with -1

		HashMap<Integer, Integer> lookup = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}

		int maxlength = 0;
		int sum = arr[0];
		lookup.put(sum, 0);

		for (int i = 1; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum == 0) {
				maxlength = Math.max(maxlength, i + 1);
			}
			
			if (!lookup.containsKey(sum)) {
				lookup.put(sum, i);
			} else {
				maxlength = Math.max(maxlength, i - lookup.get(sum));
			}
		}

		return maxlength;
	}

}
