package Md_DynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KnapSackProblem {

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
			int maxWeight = fastReader.nextInt();
			int values[] = new int[n];
			int weights[] = new int[n];

			int index = 0;
			int temp = n;
			while (--temp >= 0) {
				values[index++] = fastReader.nextInt();
			}
			index = 0;
			while (--n >= 0) {
				weights[index++] = fastReader.nextInt();
			}
			solveKnapSackProblem(maxWeight, values, weights);
		}
	}

	private static void solveKnapSackProblem(int maxWeight, int[] values, int[] weights) {
		int T[][] = new int[values.length + 1][maxWeight + 1];

		// Fill base case
		for (int i = 0; i < values.length + 1; i++) {
			T[i][0] = 0;
		}
		for (int i = 0; i < maxWeight + 1; i++) {
			T[0][i] = 0;
		}

		for (int i = 1; i < values.length + 1; i++) {
			for (int j = 1; j < maxWeight + 1; j++) {
				if (weights[i - 1] > j) {
					T[i][j] = T[i - 1][j];
				} else {
					T[i][j] = Math.max(T[i - 1][j], values[i - 1] + T[i - 1][j - weights[i - 1]]);
				}
			}
		}

		System.out.println(T[values.length][maxWeight]);
	}

}
