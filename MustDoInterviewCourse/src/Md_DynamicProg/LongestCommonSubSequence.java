package Md_DynamicProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestCommonSubSequence {

	public static class FastReader {

		BufferedReader reader;
		StringTokenizer token;

		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;

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
			int m = fastReader.nextInt();
			int n = fastReader.nextInt();
			String str1 = fastReader.nextLine();
			String str2 = fastReader.nextLine();
			solveShortestCommonSuperSequenceProblem(str1, str2);
		}
	}

	private static void solveShortestCommonSuperSequenceProblem(String str1, String str2) {
		int lcsLength = getLongestCommonSubsequence(str1, str2);
		System.out.println(lcsLength);

	}

	private static int getLongestCommonSubsequence(String str1, String str2) {
		int T[][] = new int[str1.length() + 1][str2.length() + 1];

		// Base case
		for (int i = 0; i < str1.length() + 1; i++) {
			T[i][0] = 0;
		}
		for (int i = 0; i < str2.length() + 1; i++) {
			T[0][i] = 0;
		}

		for (int i = 1; i < str1.length() + 1; i++) {
			for (int j = 1; j < str2.length() + 1; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					T[i][j] = 1 + T[i - 1][j - 1];
				} else {
					T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
				}
			}
		}

		// backTrack Logic if u want String
		/*
		 * int r = str1.length(); int c = str2.length(); int start = T[r][c]; String
		 * result = ""; while (start != 0) { if (start != T[r - 1][c] && start != T[r][c
		 * - 1]) { result = str1.charAt(r - 1) + result; r = r - 1; c = c - 1; start =
		 * T[r][c]; continue; } else if (start == T[r][c - 1]) { c = c - 1; start =
		 * T[r][c]; } else if (start == T[r - 1][c]) { r = r - 1; start = T[r][c]; }
		 * 
		 * } return result;
		 */
		return T[str1.length()][str2.length()];
	}

}
