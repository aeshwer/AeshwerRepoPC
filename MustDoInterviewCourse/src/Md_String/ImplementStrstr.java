package Md_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://practice.geeksforgeeks.org/problems/implement-strstr/1/?track=md-string&batchId=144
public class ImplementStrstr {
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

		String nextLine() {
			String str = "";
			try {
				str = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;

		}
	}

	public static void main(String[] args) {

		FastReader fastReader = new FastReader();
		int cases = fastReader.nextInt();

		while (--cases >= 0) {
			String input = fastReader.nextLine();
			String[] split = input.split(" ");
			String s = split[0];
			String x = split[1];
			problemSolution(s, x);
			problemSolution2(s, x);
		}

	}

	private static void problemSolution2(String s, String x) {
		System.out.println(s.indexOf(x));
	}

	// PatternMatching -KMP
	// this function checks if x is contained in s
	private static void problemSolution(String s, String x) {
		// create the prefix-suffix matrix
		int T[] = new int[x.length()];
		int j = 0;
		for (int i = 1; i < x.length(); i++) {
			if (x.charAt(i) == x.charAt(j)) {
				T[i] = j + 1;
				j++;
			} else {
				T[i] = j - 1 > 0 ? T[j - 1] : 0;
				j = 0;
			}

		}

		// Now check if pattern exits
		int i = 0;
		j = 0;
		while (i < s.length() && j < x.length()) {
			if (s.charAt(i) == x.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = T[j - 1];
				} else {
					i++;
				}

			}

		}

		if (j == x.length()) {
			System.out.println(i - j);
		} else {
			System.out.println("-1");
		}

	}

}
