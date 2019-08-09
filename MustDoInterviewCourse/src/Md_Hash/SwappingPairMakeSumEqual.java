//https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal/0/?track=md-hashing&batchId=144
package Md_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SwappingPairMakeSumEqual {

	public static class FastReader {
		BufferedReader reader;
		StringTokenizer token;

		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		private String next() {
			while (token == null || !token.hasMoreElements()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();
		}

	}

	private static void resolevSolution(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < arr1.length; i++) {
			sum1 += arr1[i];
			map1.put(arr1[i], 0);
		}
		for (int i = 0; i < arr2.length; i++) {
			sum2 += arr2[i];
			map2.put(arr2[i], 0);
		}

		int diff = Math.abs(sum2 - sum1);

		if (diff == 0) {
			System.out.println(1);
			return;
		}

		// if the difference is not divisible by 2 then its not possible
		if (diff % 2 == 0) {
			// array with smaller sum
			int[] arr = sum2 > sum1 ? arr1 : arr2;
			// map of array with larger sum
			Map<Integer, Integer> map = sum2 > sum1 ? map2 : map1;

			// if larger map has any key which is equal to arr[i] + (diff/2) then swapping
			// will make the sum of these arrays equal
			for (int i = 0; i < arr.length; i++) {
				if (map.containsKey(arr[i] + (diff / 2))) {
					System.out.println(1);
					return;
				}
			}
		}

		System.out.println(-1);
		return;
	}

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {

			int n = fastReader.nextInt();
			int m = fastReader.nextInt();

			int[] arr1 = new int[n];
			int i = 0;
			while (--n >= 0) {
				arr1[i++] = fastReader.nextInt();
			}

			int[] arr2 = new int[m];
			i = 0;
			while (--m >= 0) {
				arr2[i++] = fastReader.nextInt();
			}
			resolevSolution(arr1, arr2);

		}
	}

}
