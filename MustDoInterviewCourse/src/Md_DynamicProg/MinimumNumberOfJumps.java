package Md_DynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumNumberOfJumps {

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
			int jumps[] = new int[n];
			int index = 0;
			while (--n >= 0) {
				jumps[index++] = fastReader.nextInt();
			}
			solveMinNumberOfJumpsProblem(jumps);
		}
	}

	private static void solveMinNumberOfJumpsProblem(int[] jumps) {
		int T[] = new int[jumps.length];

		// Base case
		T[0] = 0;
		for (int i = 1; i < jumps.length; i++) {
			T[i] = Integer.MAX_VALUE - 1;
		}

		// Solution
		for (int i = 1; i < jumps.length; i++) {
			for (int j = 0; j < i; j++) {
				if (jumps[j] >= i - j) {
					T[i] = Math.min(1 + T[j], T[i]);
				}
			}
		}
		if (T[jumps.length - 1] != Integer.MAX_VALUE - 1)
			System.out.println(T[jumps.length - 1]);
		else {
			System.out.println(-1);
		}
	}

}
