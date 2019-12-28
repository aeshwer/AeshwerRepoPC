package Md_DynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumNumberOfCoins {

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
			int amount = fastReader.nextInt();
			solveMinimumNumberOfCoinProblem(amount);
		}
	}

	private static void solveMinimumNumberOfCoinProblem(int amount) {
		int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
		int T[] = new int[amount + 1];
		int result[] = new int[amount + 1];

		// Populate base case
		T[0] = 0;
		result[0] = 0;
		for (int i = 1; i < amount + 1; i++) {
			T[i] = Integer.MAX_VALUE - 1;
			result[i] = -1;
		}

		// Solution
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < amount + 1; j++) {
				if (coins[i] <= j) {
					if (1 + T[j - coins[i]] < T[j]) {
						T[j] = 1 + T[j - coins[i]];
						result[j] = i;
					}
				}
			}
		}

		// Print Solution

		int start = result.length - 1;
		while (start != 0) {
			int j = result[start];
			System.out.print(coins[j] + " ");
			start = start - coins[j];
		}
		System.out.println();
	}

}
