package Md_DynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequenc {

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
			int input[] = new int[n];
			int index = 0;
			while (--n >= 0) {
				input[index++] = fastReader.nextInt();
			}
			solveLongestIncreasingSubsequence(input);
		}
	}

	private static void solveLongestIncreasingSubsequence(int[] input) {
		int T[] = new int[input.length];
		int maxLength = 0;
		// Base case
		for (int i = 0; i < input.length; i++) {
			T[i] = 1;
		}

		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i]) {
					T[i] = Math.max(1 + T[j], T[i]);
				}
			}
			maxLength=Math.max(maxLength, T[i]);
		}
		System.out.println(maxLength);
	}
}
