package Md_DynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://practice.geeksforgeeks.org/problems/path-in-matrix/0/?track=md-dp&batchId=144
public class PathInMatric {

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
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = fastReader.nextInt();
				}
			}
			findPathInMatrix(arr, n);
		}
	}

	private static void findPathInMatrix(int[][] arr, int n) {
		int finalMax = 0;
		// Solution - Do Change in original matrix or Take T[][] , whatever u like
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int max = arr[i - 1][j];
				if (j - 1 >= 0) {
					max = Math.max(max, arr[i - 1][j - 1]);
				} if (j + 1 < n) {
					max = Math.max(max, arr[i - 1][j + 1]);
				}
				arr[i][j] = arr[i][j] + max;
				finalMax = Math.max(arr[i][j], finalMax);

			}
		}

		System.out.println(finalMax);

	}
}