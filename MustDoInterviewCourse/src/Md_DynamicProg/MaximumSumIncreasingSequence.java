package Md_DynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSumIncreasingSequence {

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
			if (token == null || !token.hasMoreElements()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return token.nextToken();
		}
	}

	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			int n = fastReader.nextInt();
			int arr[] = new int[n];
			int index = 0;
			while (--n >= 0) {
				arr[index++] = fastReader.nextInt();
			}
			solveMaxIncreasingSumProblem(arr);
		}
	}

	private static void solveMaxIncreasingSumProblem(int[] arr) {
		int T[] = new int[arr.length];
		int maxSum =arr[0];
		// Base case
		for (int i = 0; i < arr.length; i++) {
			T[i] = arr[i];
		}

		// Solution 
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					T[i] = Math.max(T[j] + arr[i], T[i]);
				}
			}
			maxSum = Math.max(T[i], maxSum);
		}
		System.out.println(maxSum);
	}

}
